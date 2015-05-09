package com.eeeya.fantuan.api.v1.model.table;

import com.eeeya.fantuan.api.v1.model.UserInfo;
import com.eeeya.fantuan.config.FantuanConfig;
import com.eeeya.fantuan.contants.TableIconType;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhonghui
 * @since 5/6/15.
 */
@ApiModel("餐桌参与状态")
public class TableJoinStatus extends TableElementStatus {

    @ApiModelProperty("参与人数")
    Integer joinNumber;

    @ApiModelProperty("参与人员列表")
    List<UserInfo> joinUserList;

    @ApiModelProperty("参与状态标题，比如'四缺一'")
    String tableStatusTitle;

    @ApiModelProperty("参与状态标签")
    TableIconType tableIconType;

    public TableJoinStatus() {
        // todo 测试数据
        this.joinUserList = new ArrayList<UserInfo>();
        getJoinUserList().add(new UserInfo());
        getJoinUserList().add(new UserInfo());
        getJoinUserList().add(new UserInfo());
        this.joinNumber = FantuanConfig.DEFAULT_TABLE_JOIN_NUMBER;
        this.tableStatusTitle = FantuanConfig.DEFAULT_TABLE_STATUS_TITLE;
        this.tableIconType = FantuanConfig.DEFAULT_TABLE_ICON;
    }

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

    public String getTableStatusTitle() {
        return tableStatusTitle;
    }

    public void setTableStatusTitle(String tableStatusTitle) {
        this.tableStatusTitle = tableStatusTitle;
    }

    public TableIconType getTableIconType() {
        return tableIconType;
    }

    public void setTableIconType(TableIconType tableIconType) {
        this.tableIconType = tableIconType;
    }
}
