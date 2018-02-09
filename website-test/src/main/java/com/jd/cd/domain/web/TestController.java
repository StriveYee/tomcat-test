package com.jd.cd.domain.web;

import com.jd.cd.domain.domain.MessageDto;
import com.jd.cd.domain.service.TestService;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private final static Logger log = LoggerFactory.getLogger(TestController.class);

    @Value("${web.name}")
    private String webName;
    @Resource
    private PropertyHolder propertyHolder;
    @Resource
    private VelocityEngine velocityEngine;
    @Resource
    private TestService testService;

    @RequestMapping("/测试")
    @ResponseBody
    public void codetest(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("gbk");
        System.out.println(request.getParameter("txt"));
    }

    @RequestMapping(value = "/msg", method = {RequestMethod.GET})
    @ResponseBody
    public String msg(HttpServletResponse response) {
        log.info("====请求到controller===");
        try {
//            response.getWriter().print("aa");
            return testService.getMsg();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertyHolder.getWebName();
    }

    @RequestMapping(value= "/msg2")
    @ResponseBody
    public MessageDto msg2() {
        log.info("====请求到controller===");
        MessageDto dto = new MessageDto();
        dto.setCode("111");
        dto.setDetail("中国");
        return dto;
    }

    @RequestMapping("/msg3")
    @ResponseBody
    public String msg3() {
        return "msg3";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        log.info("===请求到页面,sessionId:" + request.getSession().getId() + "===");
        return "index";
    }

    @RequestMapping("/index2")
    public ModelAndView index2(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("date", new Date());
        mv.addObject("aa", 11.123999234324);
        // 获取bb参数，测试编码问题
        String bb = request.getParameter("bb");
        mv.addObject("bb", bb);
        return mv;
    }

    @RequestMapping("/index3")
    @ResponseBody
    public String index3() {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("date", new Date());
            param.put("aa", 11.123999234324);
            param.put("bb", propertyHolder.getWebName());
            StringWriter stringWriter = new StringWriter();
            velocityEngine.mergeTemplate("index.vm","utf-8", new VelocityContext(param), stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            log.error("index3 error", e);
        }
        return "page error";
    }

}
