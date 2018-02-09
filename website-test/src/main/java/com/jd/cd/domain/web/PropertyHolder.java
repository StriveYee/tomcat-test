package com.jd.cd.domain.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/12.
 */
@Component("propertyHolder")
public class PropertyHolder {

    @Value("${web.name}")
    private String webName;

    public String getWebName() {
        return this.webName;
    }

}
