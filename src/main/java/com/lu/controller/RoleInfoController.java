package com.lu.controller;

import com.lu.dto.RoleInfoDto;
import com.lu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleInfoController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "getRoleByUserId",method = RequestMethod.POST)
    public List<RoleInfoDto> getRoleByUserId(@RequestParam int userId){
        return this.roleService.getRoleByUserId(userId);
    }

    @RequestMapping(value = "updatarole",method = RequestMethod.POST)
    public Object updatarole(@RequestParam String arr,@RequestParam String unarr,@RequestParam String userId){

        int updatarole = roleService.updatarole(arr, unarr,userId);
        System.out.println(updatarole);
        return updatarole;
    }
}
