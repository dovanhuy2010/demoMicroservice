package com.demo.upload.controller;

import com.demo.upload.dto.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWordController {
    private final Logger logger = LogManager.getLogger(HelloWordController.class);
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/")
    public ResponseEntity<Response> demo() {
        logger.info("demo");
        return new ResponseEntity<>(new Response(), HttpStatus.OK);
    }


    @RequestMapping(value = "/response", method = RequestMethod.POST)
    public ResponseEntity<String> responseList(@RequestBody String demo) {
        logger.info("success: {}",demo);
        return ResponseEntity.ok("");
    }

}
