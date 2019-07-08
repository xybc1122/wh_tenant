package com.wh.config;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "CORSFilter")
@Order(0)
public class CORSFilter implements Filter {
    @Override
    public void destroy() {
    }

    /**
     * 此过滤器只是处理跨域问题
     *
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String origin = req.getHeader("Origin");
        if (origin == null) {
            origin = req.getHeader("Referer");
        }
        resp.setHeader("Access-Control-Allow-Origin", origin);//这里不能写*，*代表接受所有域名访问，如写*则下面一行代码无效。谨记
        resp.setHeader("Access-Control-Allow-Credentials", "true");//true代表允许携带cookie
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,sso-token");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET,DELETE, PUT,OPTIONS");
        resp.setHeader("Access-Control-Max-Age", "3600");//配置Access-Control-Max-Age来缓存预检测结果

        // 如果是OPTIONS则结束请求
        if (HttpMethod.OPTIONS.toString().equals(req.getMethod())) {
            resp.setStatus(HttpStatus.NO_CONTENT.value());
            return;
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

}
