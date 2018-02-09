package com.jd.cd.domain.lisenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by Administrator on 2016/10/12.
 */
public class TestSessionLisentner implements HttpSessionListener {

    private final static Logger log = LoggerFactory.getLogger(TestSessionLisentner.class);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("===Session Created : " + se.getSession().getId() + "===");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("===Session Destroyed===");
    }
}
