package com.gst.Controller;

import com.gst.Model.User;
import com.gst.Model.UserDetails;
import com.gst.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StaffController {
    @Autowired
    UserService userService;

    @GetMapping("home/staff/them-trainer")
    public String addTrainerHome(Model model) {
        return "/Staff/add-user";
    }

    @PostMapping("home/staff/them-trainer")
    public String addTrainer(@Valid User user, @Valid UserDetails userDetails) {
        userService.saveTrainer(user, userDetails);
        return "";
    }
}
