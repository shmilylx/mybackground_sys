package com.lu.service.impl;

import com.lu.dto.RoleInfoDto;
import com.lu.mapper.RoleInfoMapper;
import com.lu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleInfoMapper roleInfoMapper;

    public List<RoleInfoDto> getRoleByUserId(int userId) {
        return this.roleInfoMapper.getRoleByUserId(userId);
    }
    public int updatarole(String arr, String unarr,String userId) {
        System.out.println(roleInfoMapper.updatarole(arr,unarr,userId));
        return roleInfoMapper.updatarole(arr,unarr,userId);
    }
}
