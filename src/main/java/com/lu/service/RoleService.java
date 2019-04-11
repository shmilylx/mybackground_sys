package com.lu.service;

import com.lu.dto.RoleInfoDto;

import java.util.List;

public interface RoleService {
    public List<RoleInfoDto> getRoleByUserId(int userId);

    int updatarole(String arr,String unarr,String userId);
}
