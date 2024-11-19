package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/"})
public class HomeController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginResult")
    public String signSuccess(@AuthenticationPrincipal OAuth2User principal, Model model) {
        model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("email", principal.getAttribute("email"));

        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception  {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "index";
    }

    @GetMapping("/signCheck")
    public String signCheck() {
        return "/signCheck";
    }

}
