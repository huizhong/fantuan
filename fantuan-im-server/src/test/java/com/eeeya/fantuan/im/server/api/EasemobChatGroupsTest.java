package com.eeeya.fantuan.im.server.api;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class EasemobChatGroupsTest {

    @Test
    public void testGetAllChatgroupids() throws Exception {

        /** 获取APP中所有的群组ID
         * curl示例:
         * curl -X GET -i "https://a1.easemob.com/easemob-playground/test1/chatgroups" -H "Authorization: Bearer {token}"
         */
        ObjectNode chatgroupidsNode = EasemobChatGroups.getAllChatgroupids();
        System.out.println(chatgroupidsNode.toString());
    }

    
    @Test
    public void testGetGroupDetailsByChatgroupid() throws Exception {

        /**
         * 获取一个或者多个群组的详情
         * curl示例
         * curl -X GET -i "https://a1.easemob.com/easemob-playground/test1/chatgroups/1414379474926191,1405735927133519"
         * -H "Authorization: Bearer {token}"
         */
        String[] chatgroupIDs = {"1431435681852924", "1405735927133519"};
        ObjectNode groupDetailNode = EasemobChatGroups.getGroupDetailsByChatgroupid(chatgroupIDs);
        System.out.println(groupDetailNode.toString());
    }

    
    @Test
    public void testCreatChatGroups() throws Exception {

        /** 创建群组
         * curl示例
         * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups' -H 'Authorization: Bearer {token}' -d '{"groupname":"测试群组","desc":"测试群组","public":true,"approval":true,"owner":"xiaojianguo001","maxusers":333,"members":["xiaojianguo002","xiaojianguo003"]}'
         */
        ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
        dataObjectNode.put("groupname", "测试群组");
        dataObjectNode.put("desc", "测试群组");
        dataObjectNode.put("approval", true);
        dataObjectNode.put("public", true);
        dataObjectNode.put("maxusers", 333);
        dataObjectNode.put("owner", "101");
        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
        arrayNode.add("101");
//        arrayNode.add("xiaojianguo003");
        dataObjectNode.put("members", arrayNode);
        ObjectNode creatChatGroupNode = EasemobChatGroups.createChatGroups(dataObjectNode);
        System.out.println(creatChatGroupNode.toString());

    }

    
    @Test
    public void testDeleteChatGroups() throws Exception {


        /**
         * 删除群组
         * curl示例
         * curl -X DELETE 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519' -H 'Authorization: Bearer {token}'
         */
        String toDelChatgroupid = "1405735927133519";
        ObjectNode deleteChatGroupNode =  EasemobChatGroups.deleteChatGroups(toDelChatgroupid) ;
        System.out.println(deleteChatGroupNode.toString());

    }

    
    @Test
    public void testGetAllMemberssByGroupId() throws Exception {



        /**
         * 获取群组中的所有成员
         * curl示例
         * curl -X GET 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users' -H 'Authorization: Bearer {token}'
         */
        String chatgroupid = "1405735927133519";
        ObjectNode getAllMemberssByGroupIdNode = EasemobChatGroups.getAllMemberssByGroupId(chatgroupid);
        System.out.println(getAllMemberssByGroupIdNode.toString());

    }

    
    @Test
    public void testAddUserToGroup() throws Exception {

        /**
         * 在群组中添加一个人
         * curl示例
         * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users/xiaojianguo002' -H 'Authorization: Bearer {token}'
         */
        String addToChatgroupid = "1431435681852924";
        String toAddUsername = "101";
        ObjectNode addUserToGroupNode = EasemobChatGroups.addUserToGroup(addToChatgroupid, toAddUsername);
        System.out.println(addUserToGroupNode.toString());


    }

    
    @Test
    public void testDeleteUserFromGroup() throws Exception {

        /**
         * 在群组中减少一个人
         * curl示例
         * curl -X DELETE 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users/xiaojianguo002' -H 'Authorization: Bearer {token}'
         */
        String delFromChatgroupid = "1405735927133519";
        String toRemoveUsername = "xiaojianguo002";
        ObjectNode deleteUserFromGroupNode = EasemobChatGroups.deleteUserFromGroup(delFromChatgroupid, toRemoveUsername);
        System.out.println(deleteUserFromGroupNode.asText());

    }

    
    @Test
    public void testGetJoinedChatgroupsForIMUser() throws Exception {

        /**
         * 获取一个用户参与的所有群组
         * curl示例
         * curl -X GET 'https://a1.easemob.com/easemob-playground/test1/users/xiaojianguo002/joined_chatgroups' -H 'Authorization: Bearer {token}'
         */
        String username = "xiaojianguo002";
        ObjectNode getJoinedChatgroupsForIMUserNode = EasemobChatGroups.getJoinedChatgroupsForIMUser(username);
        System.out.println(getJoinedChatgroupsForIMUserNode.toString());

    }

    
    @Test
    public void testAddUsersToGroupBatch() throws Exception {


        /**
         * 群组批量添加成员
         * curl示例
         * curl -X POST -i 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users' -H 'Authorization: Bearer {token}' -d '{"usernames":["xiaojianguo002","xiaojianguo003"]}'
         */
        String toAddBacthChatgroupid = "1405735927133519";
        ArrayNode usernames = JsonNodeFactory.instance.arrayNode();
        usernames.add("xiaojianguo002");
        usernames.add("xiaojianguo003");
        ObjectNode usernamesNode = JsonNodeFactory.instance.objectNode();
        usernamesNode.put("usernames", usernames);
        ObjectNode addUserToGroupBatchNode = EasemobChatGroups.addUsersToGroupBatch(toAddBacthChatgroupid, usernamesNode);
        System.out.println(addUserToGroupBatchNode.toString());

    }


}