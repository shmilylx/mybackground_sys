package com.lu.mapper;

import com.lu.pojo.UserInfo;
import com.lu.vo.UserInfoVo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {

    public UserInfo loginCheck(UserInfo userInfo);

    public int addUserInfo(UserInfo userInfo);

    public UserInfo getUserInfosBy(UserInfo userInfo);

    public int deleteById(Integer userId);

    /**
     * 根据条件查询分页数据
     * @param userInfoVo
     * @return 符合条件的数据
     */
    public List<UserInfo> getUserInfosPageBy(UserInfoVo userInfoVo);

    /**
     * 查询总数据条数
     * @return 总数据条数
     */
    public int getCount(UserInfoVo userInfoVo);

    public int updateUserInfo(UserInfo userInfo);

    public int delByForeach(Map map);
}
