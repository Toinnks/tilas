//package com.example.tilas.filter;
//
//import com.example.tilas.util.JWTUtil;
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//@WebFilter(urlPatterns = "/*")
//@Slf4j
//public class TokenFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("我运行到了 init");
//    }
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("我运行到了 doFilter,在放行前");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        //判断路径
//        String path = request.getRequestURI();
//        if(path.contains("login")){
//            filterChain.doFilter(request,response);
//            return;
//        }
//        String token =request.getHeader("token");
//        log.info("我运行到了 doFilter");
////        判断token是否为空
//        if(token==null||token.isEmpty()){
//            response.setStatus(401);
//            return;
//        }
//        // 判断token是否合法
//        try {
//            JWTUtil.parseJwt(token);
//        } catch (Exception e) {
//            response.setStatus(401);
//            return;
//        }
//        filterChain.doFilter(request,response);
//        log.info("我运行到了 doFilter,在放行后");
//    }
//
//    @Override
//    public void destroy() {
//        log.info("我运行到了 destroy");
//    }
//}
