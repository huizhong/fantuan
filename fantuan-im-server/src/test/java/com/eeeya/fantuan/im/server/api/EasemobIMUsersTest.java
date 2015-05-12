package com.eeeya.fantuan.im.server.api;

import com.eeeya.fantuan.im.server.comm.Constants;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
public class EasemobIMUsersTest {

    private static Logger LOGGER = LoggerFactory.getLogger(EasemobIMUsers.class);

    @Test
    public void testCreateNewIMUserSingle() throws Exception {

        /**
         * 注册IM用户[单个]
         */
        ObjectNode datanode = JsonNodeFactory.instance.objectNode();
        datanode.put("username","101");
        datanode.put("password", Constants.DEFAULT_PASSWORD);
        ObjectNode createNewIMUserSingleNode = EasemobIMUsers.createNewIMUserSingle(datanode);
        if (null != createNewIMUserSingleNode) {
            LOGGER.info("注册IM用户[单个]: " + createNewIMUserSingleNode.toString());
        }
    }

    @Test
    public void testCreateNewIMUserBatchGen() throws Exception {

        /**
         * 注册IM用户[批量生成用户然后注册]
         */
        String usernamePrefix = "test_user_xx";
        Long perNumber = 10L;
        Long totalNumber = 3L;
        ObjectNode createNewIMUserBatchGenNode = EasemobIMUsers.createNewIMUserBatchGen(usernamePrefix, perNumber, totalNumber);
        if (null != createNewIMUserBatchGenNode) {
            LOGGER.info("注册IM用户[批量]: " + createNewIMUserBatchGenNode.toString());
        }

    }

    @Test
    public void testGetIMUsersByPrimaryKey() throws Exception {

        /**
         * 获取IM用户[主键查询]
         */
        String userPrimaryKey = "kenshinnuser100";
        ObjectNode getIMUsersByPrimaryKeyNode = EasemobIMUsers.getIMUsersByPrimaryKey(userPrimaryKey);
        if (null != getIMUsersByPrimaryKeyNode) {
            LOGGER.info("获取IM用户[主键查询]: " + getIMUsersByPrimaryKeyNode.toString());
        }
    }


    @Test
    public void testDeleteIMUserByUserPrimaryKey() throws Exception {

        /**
         * 删除IM用户[单个]
         */
        ObjectNode deleteIMUserByUserPrimaryKeyNode = EasemobIMUsers.deleteIMUserByUserPrimaryKey("101");
        if (null != deleteIMUserByUserPrimaryKeyNode) {
            LOGGER.info("删除IM用户[单个]: " + deleteIMUserByUserPrimaryKeyNode.toString());
        }

    }

    @Test
    public void testDeleteIMUserByUsernameBatch() throws Exception {

        /**
         * 删除IM用户[批量]
         */
        Long limit = 30L;
        ObjectNode deleteIMUserByUsernameBatchNode = EasemobIMUsers.deleteIMUserByUsernameBatch(limit, null);
        if (null != deleteIMUserByUsernameBatchNode) {
            LOGGER.info("删除IM用户[批量]: " + deleteIMUserByUsernameBatchNode.toString());
        }
    }

    @Test
    public void testModifyIMUserPasswordWithAdminToken() throws Exception {

        /**
         * 重置IM用户密码 提供管理员token
         */
        String username = "kenshinnuser100";
        ObjectNode json2 = JsonNodeFactory.instance.objectNode();
        json2.put("newpassword", Constants.DEFAULT_PASSWORD);
        ObjectNode modifyIMUserPasswordWithAdminTokenNode = EasemobIMUsers.modifyIMUserPasswordWithAdminToken(username, json2);
        if (null != modifyIMUserPasswordWithAdminTokenNode) {
            LOGGER.info("重置IM用户密码 提供管理员token: " + modifyIMUserPasswordWithAdminTokenNode.toString());
        }
        ObjectNode imUserLoginNode2 = EasemobIMUsers.imUserLogin(username, json2.get("newpassword").asText());
        if (null != imUserLoginNode2) {
            LOGGER.info("重置IM用户密码后,IM用户登录: " + imUserLoginNode2.toString());
        }
    }

    @Test
    public void testAddFriendSingle() throws Exception {

        /**
         * 添加好友[单个]
         */
        String ownerUserPrimaryKey = "101";
        String friendUserPrimaryKey = "102";
        ObjectNode addFriendSingleNode = EasemobIMUsers.addFriendSingle(ownerUserPrimaryKey, friendUserPrimaryKey);
        if (null != addFriendSingleNode) {
            LOGGER.info("添加好友[单个]: " + addFriendSingleNode.toString());
        }

    }

    @Test
    public void testDeleteFriendSingle() throws Exception {

        /**
         * 解除好友关系
         **/
        ObjectNode deleteFriendSingleNode = EasemobIMUsers.deleteFriendSingle("101", "102");
        if (null != deleteFriendSingleNode) {
            LOGGER.info("解除好友关系: " + deleteFriendSingleNode.toString());
        }
    }

    @Test
    public void testGetFriends() throws Exception {

        /**
         * 添加好友[单个]
         */
        String ownerUserPrimaryKey = "101";
        String friendUserPrimaryKey = "102";
        ObjectNode addFriendSingleNode = EasemobIMUsers.addFriendSingle(ownerUserPrimaryKey, friendUserPrimaryKey);
        if (null != addFriendSingleNode) {
            LOGGER.info("添加好友[单个]: " + addFriendSingleNode.toString());
        }


        /**
         * 查看好友
         */
        ObjectNode getFriendsNode = EasemobIMUsers.getFriends(ownerUserPrimaryKey);
        if (null != getFriendsNode) {
            LOGGER.info("查看好友: " + getFriendsNode.toString());
        }

    }

    @Test
    public void testImUserLogin() throws Exception {

        /**
         * IM用户登录
         */
        ObjectNode imUserLoginNode = EasemobIMUsers.imUserLogin("101", "1");
        if (null != imUserLoginNode) {
            LOGGER.info("IM用户登录: " + imUserLoginNode.toString());
        }

    }
}