package com.example.lbddemo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private Log logger= LogFactory.getLog(HelloController.class);

    @GetMapping("/")
    public String getHello(){
        logger.trace("TRACE");
        logger.debug("DEBUG");
        logger.info("INFO");
        logger.warn("WARN");
        logger.error("ERROR");
        return "HELLO";
    }
}
