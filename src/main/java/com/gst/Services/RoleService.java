package com.gst.Services;

import com.gst.Model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Iterable <Role> findAll();
}
