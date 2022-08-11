package com.kuang.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.kuang.reggie.common.BaseContext;
import com.kuang.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否完成登录
 */
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //用来进行路径比较，路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /**
         * 1.获取本次请求uri
         * 2.判断本次请求是否需要处理
         * 3.不需要处理则直接放行
         * 4.需要处理，判断登录状态，如果已登录，放行
         * 5.如果未登录则返回未登录结果
         */
        //1.获取本次请求uri
        String requestURI = request.getRequestURI();

        log.info("拦截到请求：{}",requestURI);

        //2.判断本次请求是否需要处理
        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**"

        };
        boolean check = check(urls, requestURI);

        //3.不需要处理则直接放行
        if(check){
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request,response);
            return;
        }

        //4.需要处理，判断登录状态，如果已登录，放行
        if(request.getSession().getAttribute("employee") != null){
            log.info("用户已登录");

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request,response);
            return;
        }

        log.info("用户未登录");
        //5.如果未登录则返回未登录结果,通过输出流方式向用户端相应数据
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
