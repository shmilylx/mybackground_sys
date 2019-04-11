package com.lu.dto;

import com.lu.pojo.UserInfo;
import com.lu.tools.SplitePageBean;

import java.util.List;

public class UserInfoDto {
    //当前页数据
    List<UserInfo> userInfoList;
    //分页数据
    SplitePageBean splitePageBean;

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public SplitePageBean getSplitePageBean() {
        return splitePageBean;
    }

    public void setSplitePageBean(SplitePageBean splitePageBean) {
        this.splitePageBean = splitePageBean;
    }
}
