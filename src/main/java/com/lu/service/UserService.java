package com.lu.service;

import com.lu.pojo.UserInfo;
import com.lu.vo.UserInfoVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    public boolean loginCheck(UserInfo userInfo);

    public boolean addUserInfo(UserInfo userInfo);
    public UserInfo getUserInfosBy(UserInfo userInfo);

    public int deleteById(Integer userId);

    public int getCount(UserInfoVo userInfoVo);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    public boolean updateUserInfo(UserInfo userInfo);

    public boolean delByForeach(Map map);

}
