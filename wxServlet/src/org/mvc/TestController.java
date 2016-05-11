package org.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc")
public class TestController { 
    @RequestMapping("/hello")
    public String hello(){        
        return "test1";
    }
}
