package com.jd.cd.domain.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/10/11.
 */
public class TestIntercepter extends HandlerInterceptorAdapter {

    private final static Logger log = LoggerFactory.getLogger(TestIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("===Intercepter preHandle===");
//        try {
//            response.getWriter().print("intercepter");
//            response.getWriter().close();
//        } catch (Exception e) {
//            response.getWriter().close();
//        }
//        return true;
//        return false;
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("===Intercepter postHandle===");
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("===Intercepter afterCompletion===");
        super.afterCompletion(request, response, handler, ex);
    }


}
