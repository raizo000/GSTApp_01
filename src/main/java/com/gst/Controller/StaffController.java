package com.gst.Controller;

import com.gst.Model.User;
import com.gst.Model.UserDetails;
import com.gst.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StaffController {
    @Autowired
    UserService userService;

    @GetMapping("home/staff/add-user")
    public String addTrainerHome(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userDetails", new UserDetails());
        return "/Staff/addUser";
    }

    @PostMapping("home/staff/add-user")
    public String addTrainer(@Valid User user, @Valid UserDetails userDetails, Model model, BindingResult bindingResult) {

        User existUser = userService.findUserByEmail(user.getEmail());
        if (existUser != null) {
            bindingResult.rejectValue("email", "error.user", "Email đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            return "/Staff/addUser";
        } else {
            userService.saveTrainer(user, userDetails);
            model.addAttribute("successMessage", "Tạo tài khoản thành công");
        }
        return "/Staff/addUser";
    }
}
