package com.gst.Services;

import com.gst.Model.Role;
import com.gst.Model.User;
import com.gst.Model.UserDetails;
import com.gst.Repository.RoleRepository;
import com.gst.Repository.UserDetailsRepository;
import com.gst.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRole(user.getRole());

        if (user.getRole().getId() == 3) {
            UserDetails userDetails = new UserDetails();
            userDetails.setUser(user);
            userDetailsRepository.save(userDetails);
        }
        userRepository.save(user);
    }

    @Override
    public void saveTrainer(User user, UserDetails userDetails) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRole(user.getRole());
        userDetails.setUser(user);
        userDetailsRepository.save(userDetails);
        userRepository.save(user);
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAllUserActive() {
        return userRepository.findAllByActive(1);
    }

    @Override
    public List<User> findAllbyEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    @Override
    public void updatePassword(int id, User user) {
        userRepository.updatePassword(id, bCryptPasswordEncoder.encode(user.getPassword()), user.getRole().getId());
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }


}
