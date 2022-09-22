package com.demo.export.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("export-service")
public class DemoExportController {
    private final Logger logger = LogManager.getLogger(DemoExportController.class);

    @Autowired
    private RestTemplate restTemplate;

//    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<String> demo() {

        try {
            URI url = new URI("http://upload/response");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> dataSend =new HttpEntity<>("send to upload",headers);
            restTemplate.postForEntity(url,dataSend,String.class);
            logger.info("ok");
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> test() {
        logger.info("return");

        return new ResponseEntity<>("happy", HttpStatus.OK);
    }
}
