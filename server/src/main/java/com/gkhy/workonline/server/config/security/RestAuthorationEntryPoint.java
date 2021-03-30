package com.gkhy.workonline.server.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gkhy.workonline.server.utils.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class RestAuthorationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        final PrintWriter out = response.getWriter();
        R r = R.error(403, "未登陆，请登录");
        out.write(new ObjectMapper().writeValueAsString(r));
        out.flush();
        out.close();
    }
}
