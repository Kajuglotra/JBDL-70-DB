package com.gfg.JBDL70DB;

import com.sun.net.httpserver.Headers;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/v1")
public class ControllerDemo {

    private static final Log logger = LogFactory.getLog(ControllerDemo.class);

    @GetMapping("/demo")
    public String getDemo(){

        logger.debug("warn logs");
        return "demo";
    }

    @PostMapping("/post/demo")
    public String postDemo(){
        return "Post demo";
    }

    @PutMapping("/post/demo")
    public String putDemo(){
        return "Put Demo";
    }

    @RequestMapping(method = RequestMethod.HEAD, path = "/head/demo")
    public void headDemo(HttpServletRequest request, HttpServletResponse response){

        Map<String,List<String>> header= new HashMap<String, List<String>>();
        List<String> list = new ArrayList<>();
        list.add("dummy");
        header.put("header", list);
        response.setHeader("header" , header.toString());

    }

}
