package com.gfg.JBDL70DB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/v2")
public class ControllerDemo2 {

    @GetMapping("/demo")
    public String getDemo(){
        return "demo2";
    }

    @GetMapping("/dynamic-demo")
    public ModelAndView getDynamicData(){
        ModelAndView modelAndView = new ModelAndView("DynamicDemo.html");
        modelAndView.getModelMap().addAttribute("name" , "JOHN");
        return modelAndView;
    }
}
