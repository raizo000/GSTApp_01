package com.gst.Controller;

import com.gst.Model.AjaxResponse;
import com.gst.Model.SearchCriteria;
import com.gst.Model.User;
import com.gst.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SearchRestController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("home/staff/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria user) {
        Object aa = user;
        AjaxResponse result = new AjaxResponse();
        if (user.getOption().equals("1")) {
            List<User> users = userService.findAllbyEmail(user.getUsername());
            result.setResult(users);
        } else if (user.getOption().equals("2")) {
            List<User> users = userService.findAllByToiec(user.getUsername());
            result.setResult(users);
        }
        return ResponseEntity.ok(result);
    }
}

