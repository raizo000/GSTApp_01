package com.gst.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping({"/", "/login"})
    public String LoginPage() {
        return "/Login/Login";
    }

    @GetMapping("/home/admin")
    public String Home() {
        return "/Admin/Home";
    }

    @GetMapping("/home/staff")
    public String StaffHome() {
        return "/Staff/Home";
    }
}
