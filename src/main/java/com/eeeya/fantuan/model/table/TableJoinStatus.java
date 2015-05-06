package com.eeeya.fantuan.model.table;

import com.eeeya.fantuan.contants.TableIconType;
import com.eeeya.fantuan.model.UserInfo;

import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
public class TableJoinStatus extends TableElementStatus {

    Integer joinNumber;
    List<UserInfo> joinUserList;
    String tableStatusComment;
    TableIconType tableIconType;

    public Integer getJoinNumber() {
        return joinNumber;
    }

    public void setJoinNumber(Integer joinNumber) {
        this.joinNumber = joinNumber;
    }

    public List<UserInfo> getJoinUserList() {
        return joinUserList;
    }

    public void setJoinUserList(List<UserInfo> joinUserList) {
        this.joinUserList = joinUserList;
    }

    public String getTableStatusComment() {
        return tableStatusComment;
    }

    public void setTableStatusComment(String tableStatusComment) {
        this.tableStatusComment = tableStatusComment;
    }

    public TableIconType getTableIconType() {
        return tableIconType;
    }

    public void setTableIconType(TableIconType tableIconType) {
        this.tableIconType = tableIconType;
    }
}
