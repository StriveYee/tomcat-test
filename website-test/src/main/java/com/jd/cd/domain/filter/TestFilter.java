package com.jd.cd.domain.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2016/10/11.
 */
public class TestFilter implements Filter {

    private final static Logger log = LoggerFactory.getLogger(TestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("===Filter init===");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("===Filter doFilter===");
        try {

        } catch (Exception e) {

        }
        chain.doFilter(request, response);
        log.info("===Filter doFilter End===");
    }

    @Override
    public void destroy() {
        log.info("===Filter destroy===");
    }
}
