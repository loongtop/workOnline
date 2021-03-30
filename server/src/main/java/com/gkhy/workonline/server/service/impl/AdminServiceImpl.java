package com.gkhy.workonline.server.service.impl;

import com.gkhy.workonline.server.config.security.JwtTokenUtil;
import com.gkhy.workonline.server.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gkhy.workonline.server.utils.PageUtils;

import com.gkhy.workonline.server.dao.AdminDao;
import com.gkhy.workonline.server.entity.AdminEntity;
import com.gkhy.workonline.server.service.AdminService;
import springfox.documentation.spi.service.contexts.SecurityContextBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Service("adminService")
public class AdminServiceImpl extends ServiceImpl<AdminDao, AdminEntity> implements AdminService {

    @Autowired
    AdminDao adminDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired(required=false)
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

    @Override
    public R login(String username, String password, HttpServletRequest request) {
        //登陆验证
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return R.error("leo用户名或密码不正确！");
        }

        if(userDetails.isEnabled()){
            return R.error("leo禁用，请联系管理员！");
        }

        //更新security全局对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //获取token
        final String token = jwtTokenUtil.generateToken(userDetails);
        return R.ok("leo登陆成功！").put("token", token);
    }


    public AdminEntity getAdminEntityByUserName(String username){
        return adminDao.selectOne(new QueryWrapper<AdminEntity>().eq("username", username).eq("enabled", true));
    }



}