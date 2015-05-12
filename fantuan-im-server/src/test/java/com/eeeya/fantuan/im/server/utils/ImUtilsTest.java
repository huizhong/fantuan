package com.eeeya.fantuan.im.server.utils;

import com.eeeya.fantuan.im.server.exception.ImException;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;


public class ImUtilsTest {

    @Before
    public void createSystemUserId() {
        try {
            ImUtils.createUser(ImUtils.SYSTEM_USER_ID, "token", "系统账户，每个群都参加");
        } catch (ImException ignore) {
        }
    }

    @Test
    public void testCreateGroup() throws Exception {
        String userId = String.valueOf(new Date().getTime());
        String userId2 = userId + "2";
        ImUtils.createUser(userId, "token", "小灰灰");
        ImUtils.createUser(userId2, "token", "小灰灰2");
        String groupId = ImUtils.createGroup();
        ImUtils.addUserToGroup(groupId, userId2);
    }
}