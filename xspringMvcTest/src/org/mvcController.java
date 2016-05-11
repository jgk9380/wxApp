package org;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acct")
public class mvcController {
 
    @RequestMapping("/v")
    public String hello(){        
        return "accountv";
    }
    @RequestMapping("/e")
    public String hello1(){        
        return "accounte";
    }
}
