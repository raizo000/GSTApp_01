package com.gst.Controller;


import com.gst.Model.Role;
import com.gst.Model.User;
import com.gst.Services.RoleService;
import com.gst.Services.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AdminController {
    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;

    @GetMapping("home/admin/add-user")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "/Admin/addUser";
    }

    @PostMapping("home/admin/add-user")
    public String AddUser(Model model, @Valid User user, BindingResult bindingResult) {
        User existUser = userService.findUserByEmail(user.getEmail());
        if (existUser != null) {
            bindingResult.rejectValue("email", "error.user", "Email đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            return "/Admin/addUser";
        } else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "Tạo tài khoản thành công");
            return "/Admin/addUser";
        }
    }

    @GetMapping("home/admin/user-list")
    public String getUserList(Model model) {
        model.addAttribute("user", userService.findAllUserActive());
        return "/Admin/user_list";
    }

    @GetMapping("home/admin/thay-doi-mat-khau/{id}")
    public String editPassword(Model model, @PathVariable int id) {
        model.addAttribute("users", userService.findOne(id));
        model.addAttribute("user", new User());
        return "/Admin/editUser";

    }

    @PostMapping("home/admin/luu-mat-khau/{id}")
    public String savePassword(@PathVariable int id, @Valid User user, RedirectAttributes redirectAttributes) {
        Object aaa = user;
        userService.updatePassword(id, user);
        redirectAttributes.addFlashAttribute("successEdit", "Cập nhật thành công tài khoản" + userService.findOne(id).getEmail());
        return "redirect:/home/admin/user-list";
    }

    @GetMapping("home/admin/xoa-tai-khoan/{id}")
    public String deleteUser(@PathVariable int id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("successDelete", "Xóa thành công tài khoản" + userService.findOne(id).getEmail());
        return "redirect:/home/admin/user-list";
    }
    @GetMapping("home/admin/search-user")
    public String ajax(){
        return "/Admin/SearchAjax";
    }

}

