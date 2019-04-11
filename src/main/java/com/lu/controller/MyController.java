package com.lu.controller;

import com.lu.dto.UserInfoDto;
import com.lu.pojo.UserInfo;
import com.lu.service.UserService;
import com.lu.tools.Md5Utils;
import com.lu.tools.SplitePageBean;
import com.lu.vo.UserInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "clearSession",method = RequestMethod.GET)
    public void clearSession(HttpSession httpSession){
        httpSession.removeAttribute("userInfo");
        System.out.println("clear!!");
    }

    @ResponseBody
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody UserInfo userInfo) throws Exception {
        boolean flag = false;
        userInfo.setPassword(Md5Utils.encodePassword(userInfo.getPassword()));
        flag = this.userService.addUserInfo(userInfo);
        return flag;
    }

//    @ResponseBody
//    @RequestMapping(value = "addUser",method = RequestMethod.POST)
//    public Object addUser(@RequestBody UserInfo userInfo){
//        System.out.println(userInfo);
//        boolean flag = this.userService.addUserInfo(userInfo);
//        return flag;
//    }


    @ResponseBody
    @RequestMapping(value = "loginCheck",method = RequestMethod.POST)
    public String loginCheck(@RequestBody UserInfo userInfo, HttpSession httpSession){
        Boolean flag = false;
        userInfo.setPassword(Md5Utils.encodePassword(userInfo.getPassword()));
        System.out.println("username="+userInfo.getUsername()+",password="+userInfo.getPassword());
        flag = userService.loginCheck(userInfo);
        if(flag){
            httpSession.setAttribute("userInfo",userInfo);
        }
        return flag.toString();
    }


    @ResponseBody
    @RequestMapping(value = "userInfoList",method = RequestMethod.POST)
    public Object userInfoList(@RequestBody(required = false) UserInfoVo userInfoVo){
        //查询并返回UserInfoDto对象
      //  System.out.println(userInfoVo);
        //当前是第几页、每页多少行
//        UserInfoVo???
        List<UserInfo> userInfoList = this.userService.getUserInfosPageBy(userInfoVo);
//        System.out.println(userInfoList.toString()+"11111");
        //返回集合
        //返回页面
        SplitePageBean splitePageBean = new SplitePageBean();
        int count = this.userService.getCount(userInfoVo);
        splitePageBean.setCurrentPage(userInfoVo.getSplitePageBean().getCurrentPage());
        splitePageBean.setDataCount(count);
        splitePageBean.setPageCount(count%3==0?count/3:count/3+1);
        UserInfoDto dto = new UserInfoDto();
        dto.setUserInfoList(userInfoList);
        dto.setSplitePageBean(splitePageBean);
        return dto;
    }

    @ResponseBody
    @RequestMapping(value = "remove",method = RequestMethod.POST)
    public int remove(@Param("userId") String userId) {
        int id = Integer.parseInt(userId);
        int i = this.userService.deleteById(id);
        return i;
    }


    @ResponseBody
    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public Object updateUserInfo(@RequestBody UserInfo userInfo){
        System.out.println(userInfo);
        if(userInfo.getUserId()==0){
            return false+"";
        }
        boolean flag = this.userService.updateUserInfo(userInfo);
        return flag;
    }

    @ResponseBody
    @RequestMapping(value = "selectUserInfo",method = RequestMethod.POST)
    public Object selectUserInfo(@RequestBody(required = false)UserInfo userInfo){

        UserInfo userInfosBy = this.userService.getUserInfosBy(userInfo);
        return userInfosBy;
    }

    //批量删除
    @ResponseBody
    @RequestMapping(value = "delUserInfo",method = RequestMethod.GET)
    public String delByForeach(@RequestParam(value = "ids[]", required = false) Integer[] ids){
        Map<String,Object> map = new HashMap();
        map.put("ids",ids);
        Boolean flag = this.userService.delByForeach(map);
        return flag.toString();
    }
}
