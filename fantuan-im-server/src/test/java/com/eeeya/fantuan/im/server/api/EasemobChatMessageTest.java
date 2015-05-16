package com.eeeya.fantuan.im.server.api;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasemobChatMessageTest {
    private static JsonNodeFactory factory = new JsonNodeFactory(false);
    private static Logger LOGGER = LoggerFactory.getLogger(EasemobChatMessageTest.class);

    @Test
    public void testGet20ChatMessages() throws Exception {


        // 聊天消息 获取最新的20条记录
        ObjectNode queryStrNode = factory.objectNode();
//        queryStrNode.put("limit", "1000");
        ObjectNode messages = EasemobChatMessage.getChatMessages(queryStrNode);
        LOGGER.debug(messages.toString());
    }


    @Test
    public void testGet7DChatMessages() throws Exception {
        // 聊天消息 获取7天以内的消息
        String currentTimestamp = String.valueOf(System.currentTimeMillis());
        String senvenDayAgo = String.valueOf(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000);
        ObjectNode queryStrNode1 = factory.objectNode();
        queryStrNode1.put("ql", "select * where  timestamp > " + senvenDayAgo + " and timestamp < " + currentTimestamp);
        ObjectNode messages1 = EasemobChatMessage.getChatMessages(queryStrNode1);
    }

    @Test
    public void testGetChatMessagesByPage() throws Exception {
        // 聊天消息 分页获取
        ObjectNode queryStrNode2 = factory.objectNode();
        queryStrNode2.put("limit", "20");
        // 第一页
        ObjectNode messages2 = EasemobChatMessage.getChatMessages(queryStrNode2);
        // 第二页
        String cursor = messages2.get("cursor").asText();
        queryStrNode2.put("cursor", cursor);
        ObjectNode messages3 = EasemobChatMessage.getChatMessages(queryStrNode2);
    }
}