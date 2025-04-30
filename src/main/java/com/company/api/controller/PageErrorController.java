package com.company.api.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageErrorController implements ErrorController {

    @GetMapping("/error")
    public ResponseEntity<String> errorPage(){
        return ResponseEntity.ok("404 Page Not Found");
    }
}
