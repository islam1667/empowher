package com.company.api.controller;

import com.company.api.dto.UserEntityDto;
import com.company.api.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthenticationController {

    UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login-page.html");
    }

    @GetMapping("/signup")
    public ModelAndView getRegistrationPage(){
        return new ModelAndView("signup-page.html");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserEntityDto userEntityDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        userService.registerUser(userEntityDto);
        System.out.println("new user registered");
        return ResponseEntity.ok("{\"message\": \"Check your email (check for spam folder also) and verify your account to login.\"}");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verify(
            @RequestParam(name = "token", defaultValue = "-1") String token){
        userService.verifyUserByToken(token);
        return ResponseEntity.ok("User verified, now you can login");
    }
}
