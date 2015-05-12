package com.eeeya.fantuan.im.server.utils;

import com.eeeya.fantuan.im.server.api.EasemobChatGroups;
import com.eeeya.fantuan.im.server.api.EasemobIMUsers;
import com.eeeya.fantuan.im.server.exception.ImException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author zhonghui
 * @since 5/12/15.
 */
public class ImUtils {
    public static final String SYSTEM_USER_ID = "99";

    static final Integer DEFAULT_ERROR_STATUS_CODE = 400;
    static final Integer DEFAULT_SUCCESS_STATUS_CODE = 200;

    static Logger LOGGER = LogManager.getLogger(ImUtils.class);

    public static void createUser(String userId, String userToken, String nickName) throws ImException {

        /**
         * 注册IM用户[单个]
         */
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username", userId);
        datanode.put("password", userToken);
        if (StringUtils.isNotEmpty(nickName)) {
            datanode.put("nickname", nickName);
        }
        ObjectNode createNewIMUserSingleNode = EasemobIMUsers.createNewIMUserSingle(datanode);
        checkResult(createNewIMUserSingleNode);
    }

    /**
     * 在群组中添加一个人
     * curl示例
     * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users/xiaojianguo002' -H 'Authorization: Bearer {token}'
     */
    public static void addUserToGroup(String groupId, String userId) throws ImException {
        ObjectNode addUserToGroupNode = EasemobChatGroups.addUserToGroup(groupId, userId);
        checkResult(addUserToGroupNode);
    }

    /**
     * 创建群组
     * 群主为系统账号
     * curl示例
     * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups' -H 'Authorization: Bearer {token}' -d '{"groupname":"测试群组","desc":"测试群组","public":true,"approval":true,"owner":"xiaojianguo001","maxusers":333,"members":["xiaojianguo002","xiaojianguo003"]}'
     */

    public static String createGroup(String groupName, String groupDesc, Boolean retry) throws ImException {

        ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
        dataObjectNode.put("groupname", groupName);
        dataObjectNode.put("desc", groupDesc);
        dataObjectNode.put("approval", true);
        dataObjectNode.put("public", false);
        dataObjectNode.put("maxusers", 200);
        dataObjectNode.put("owner", SYSTEM_USER_ID);
        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
//        for(String userId : userIdList) {
//            arrayNode.add(userId);
//        }
        dataObjectNode.put("members", arrayNode);
        ObjectNode createChatGroupNode;
        try {
            createChatGroupNode = EasemobChatGroups.createChatGroups(dataObjectNode);
            checkResult(createChatGroupNode);
        } catch (ImException e) {
            if (retry) {
                createChatGroupNode = EasemobChatGroups.createChatGroups(dataObjectNode);
                checkResult(createChatGroupNode);
            } else {
                throw e;
            }
        }
        return createChatGroupNode.get("data").get("groupid").asText();
    }

    public static String createGroup() throws ImException {
        return createGroup("fantuan", "fantuan", false);
    }

    private static void checkResult(ObjectNode objectNode) throws ImException {

        if (null != objectNode) {
            LOGGER.info("Check Result: " + objectNode.toString());
        } else {
            throw new ImException("null result", DEFAULT_ERROR_STATUS_CODE, null);
        }
        if (objectNode.has("message")) {
            throw new ImException(objectNode.get("message").toString(), DEFAULT_ERROR_STATUS_CODE, null);
        }
        if (objectNode.has("statusCode")) {
            Integer statusCode = objectNode.get("statusCode").asInt();
            if (!DEFAULT_SUCCESS_STATUS_CODE.equals(statusCode)) {
                throw new ImException(objectNode.get("error").toString(), statusCode, objectNode.get("error_description").textValue());
            }
        }
    }

    public static void setUserPassword(String userId, String newPassword) throws ImException {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("newpassword", newPassword);
        ObjectNode result = EasemobIMUsers.modifyIMUserPasswordWithAdminToken(userId, objectNode);
        checkResult(result);
    }

}
