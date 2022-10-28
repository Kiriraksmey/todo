package com.example.todo.model.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class logincontroller {
    @Autowired
    private Loginservice userService;
    @GetMapping("login")
    public String home(){

        return "login-page/login";

    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {

        Login oauthUser = userService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {

            return "redirect:/";


        } else {
            return "redirect:login-page/login";


        }

    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {


        return "redirect:login-page/login";
    }
}
