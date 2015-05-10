package com.eeeya.fantuan.server.api.v1.model.table.status;

import com.eeeya.fantuan.server.api.v1.model.UserInfo;
import com.eeeya.fantuan.server.contants.TableIconType;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

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
    String tableStatusLabel;

    @ApiModelProperty("参与状态标签")
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

    public String getTableStatusLabel() {
        return tableStatusLabel;
    }

    public void setTableStatusLabel(String tableStatusLabel) {
        this.tableStatusLabel = tableStatusLabel;
    }

    public TableIconType getTableIconType() {
        return tableIconType;
    }

    public void setTableIconType(TableIconType tableIconType) {
        this.tableIconType = tableIconType;
    }
}
