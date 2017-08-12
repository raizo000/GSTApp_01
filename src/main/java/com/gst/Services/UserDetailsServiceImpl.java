package com.gst.Services;

import com.gst.Model.UserDetails;
import com.gst.Repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public List<UserDetails> findAllAciveUserDetails() {
        return userDetailsRepository.findAllByActive(1);
    }
}
