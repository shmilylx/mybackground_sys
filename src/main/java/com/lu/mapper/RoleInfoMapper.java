package com.lu.mapper;

import com.lu.dto.RoleInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoMapper {
    public List<RoleInfoDto> getRoleByUserId(int userId);

    int updatarole(@Param("arr") String arr, @Param("unarr") String unarr, @Param("userId") String userId);

}
