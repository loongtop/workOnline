package com.gkhy.workonline.server.controller;

import com.gkhy.workonline.server.entity.AdminEntity;
import com.gkhy.workonline.server.entity.AdminLoginParam;
import com.gkhy.workonline.server.service.AdminService;
import com.gkhy.workonline.server.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.security.Principal;

@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
    AdminService adminService;

    @ApiOperation(value = "登陆之后返回token")
    @PostMapping("/login")
    public R login(AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), request);
    }

    @ApiOperation(value = "获取当前用户信息")
    public AdminEntity getAdminEntity(Principal principal){
        if ( null == principal) {
            return null;
        }

        String username = principal.getName();
        AdminEntity adminEntity = adminService.getAdminEntityByUserName(username);
        adminEntity.setPassword(null);

        return adminEntity;
    }


    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public R logout(){
        return R.ok("退出成功");
    }


}
