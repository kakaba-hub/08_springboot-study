package com.kyungbae.security.controller;

import com.kyungbae.security.dto.UserDto;
import com.kyungbae.security.dto.auth.LoginUser;
import com.kyungbae.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/login")       // 인증X
    public void loginPage(){}

    @GetMapping("/signup")      // 인증X
    public void siginupPage(){}

    @GetMapping("/admin/main")
    public void adminMainPage(){}

    @GetMapping("/user/main")
    public void userMainPage(@AuthenticationPrincipal LoginUser loginUser){
        System.out.println("아이디: " + loginUser.getUsername());
        System.out.println("비번: " + loginUser.getPassword());
        System.out.println("이름: " + loginUser.getDisplayName());
        System.out.println("권한목록: " + loginUser.getAuthorities());
    }

    @PostMapping("/signup")
    public String signup(UserDto user, RedirectAttributes redirectAttributes){
        Map<String, String> map = userService.registUser(user);
        redirectAttributes.addFlashAttribute("message", map.get("message"));
        return "redirect:" + map.get("path");
    }

}
