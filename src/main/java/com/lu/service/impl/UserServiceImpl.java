package com.lu.service.impl;

import com.lu.mapper.UserInfoMapper;
import com.lu.pojo.UserInfo;
import com.lu.service.UserService;
import com.lu.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserInfoMapper userInfoMapper;

    public boolean loginCheck(UserInfo userInfo) {
        if(userInfoMapper.loginCheck(userInfo)!=null){
            return true;
        }
        return false;
    }

    public boolean addUserInfo(UserInfo userInfo){

        boolean flag = false;
        if(this.userInfoMapper.addUserInfo(userInfo)>0){
            flag = true;
        }
        return flag;
    }

    public UserInfo getUserInfosBy(UserInfo userInfo){
        return this.userInfoMapper.getUserInfosBy(userInfo);
    }

    public int deleteById(Integer userId) {
        return this.userInfoMapper.deleteById(userId);
    }

    public int getCount(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getCount(userInfoVo);
    }

    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo) {
        return this.userInfoMapper.getUserInfosPageBy(userInfoVo);
    }

    public boolean updateUserInfo(UserInfo userInfo){
        boolean flag = false;
        if(this.userInfoMapper.updateUserInfo(userInfo)>0){
            flag = true;
        }
        return flag;
    }
    public boolean delByForeach(Map map) {
        if(this.userInfoMapper.delByForeach(map)>0){
            return true;
        }
        return false;
    }

}
