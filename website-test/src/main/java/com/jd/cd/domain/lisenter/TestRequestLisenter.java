package com.jd.cd.domain.lisenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/10/11.
 */
public class TestRequestLisenter implements ServletRequestListener {

    private final static Logger log = LoggerFactory.getLogger(TestRequestLisenter.class);

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("===request Destroyed===");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("===request Initialized===");
        log.info("request uri:" + ((HttpServletRequest)sre.getServletRequest()).getRequestURI());

    }
}
