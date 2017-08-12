package com.gst.Services;

import com.gst.Model.UserDetails;

import java.util.List;

public interface UserDetailService {
    List<UserDetails> findAllAciveUserDetails();
}
