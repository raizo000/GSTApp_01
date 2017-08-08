package com.gst.Controller;

import com.gst.Model.AjaxResponse;
import com.gst.Model.SearchCriteria;
import com.gst.Model.User;
import com.gst.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchRestController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("home/admin/search")
    public List<User> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria user) {
        Object aa = user;
        AjaxResponse result = new AjaxResponse();


        return userService.findAllbyEmail(user.getUsername());

    }
}

