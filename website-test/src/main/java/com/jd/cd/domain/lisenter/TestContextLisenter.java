package com.jd.cd.domain.lisenter;

import com.jd.cd.domain.web.TestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2016/10/12.
 */
public class TestContextLisenter implements ServletContextListener {

    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("===context Initialized===");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("===context Destroyed===");
    }
}
