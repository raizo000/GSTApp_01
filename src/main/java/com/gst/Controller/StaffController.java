package com.gst.Controller;

import com.gst.Model.Category;
import com.gst.Model.Course;
import com.gst.Model.User;
import com.gst.Model.UserDetails;
import com.gst.Services.CategoryCourseService;
import com.gst.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class StaffController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryCourseService categoryCourseService;

    @GetMapping("home/staff/add-user")
    public String addTrainerHome(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userDetails", new UserDetails());
        return "/Staff/addUser";
    }

    @GetMapping("home/staff/user-list")
    public String getTrainerList(Model model) {
        Object a = userService.findTrainer();
        model.addAttribute("user", userService.findTrainer());
        return "/Staff/user_list";
    }

    @GetMapping("home/staff/thay-doi-thong-tin/{id}")
    public String editTrainer(Model model, @PathVariable int id) {
        model.addAttribute("users", userService.findOne(id));
        Object aa = userService.findTrainerDetails(id);
        model.addAttribute("userDetails", userService.findTrainerDetails(id));
        return "/Staff/editUser";

    }

    @PostMapping("/home/staff/luu-thay-doi-thong-tin/{id}")
    public String postEditTrainer(@PathVariable int id, @Valid UserDetails userDetails, RedirectAttributes redirectAttributes) {
        userService.updateTrainerDetails(id, userDetails);
        redirectAttributes.addFlashAttribute("successEdit", "Cập nhật thành công tài khoản" + userService.findOne(id).getEmail());
        return "redirect:/home/staff/user-list";
    }

    @PostMapping("home/staff/add-user")
    public String addTrainer(@Valid User user, @Valid UserDetails userDetails, Model model) {

        User userExist = userService.findUserByEmail(user.getEmail());
        if (userExist != null) {
            model.addAttribute("emailError", "Email đã được sử dụng");
        } else {
            userService.saveTrainer(user, userDetails);
            model.addAttribute("successMessage", "Tạo tài khoản thành công");
        }
        return "/Staff/addUser";
    }

    @GetMapping("home/staff/add-category")
    public String addCategoryHome(Model model) {
        model.addAttribute("category", new Category());
        return "/Staff/addCategory";
    }


    @PostMapping("home/staff/add-category")
    public String addCategory(@Valid Category category, Model model, BindingResult bindingResult) {
        Category existCategory = categoryCourseService.findCategoryName(category.getName());
        if (existCategory != null) {
            bindingResult.rejectValue("name", "error.name", "Category đã tồn tại");
        }
        if (bindingResult.hasErrors()) {
            return "staff/addCategory";
        } else {
            categoryCourseService.saveCategory(category);
            model.addAttribute("categorySuccess", "Thêm Category thành công");
            return "staff/addCategory";
        }

    }

    @GetMapping("home/staff/add-course")
    public String addCourseHome(Model model) {
        model.addAttribute("category", categoryCourseService.findAllCategory());
        model.addAttribute("course", new Course());
        return "staff/addCourse";
    }

    @PostMapping("home/staff/add-course")
    public String addcourse(Course course) {
        categoryCourseService.saveCourse(course);
        return "staff/addCourse";
    }
}
