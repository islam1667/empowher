package com.company.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String index() {
        return "empowher-homepage"; // returns empowher-homepage.html from templates
    }

    @GetMapping("/video")
    public String video() {
        return "video-page"; // returns empowher-homepage.html from templates
    }
}