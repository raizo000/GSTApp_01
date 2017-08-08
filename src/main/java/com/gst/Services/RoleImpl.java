package com.gst.Services;

import com.gst.Model.Role;
import com.gst.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleImpl implements RoleService {
    @Autowired
    RoleRepository repo;

    @Override
  public  Iterable<Role> findAll() {
        return repo.findAll();
    }
}
