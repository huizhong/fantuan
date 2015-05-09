package com.eeeya.fantuan.dao;

import com.eeeya.fantuan.api.v1.model.UserInfo;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
public interface UserDAO {
    UserInfo getUserInfoById(Long userId);
}
