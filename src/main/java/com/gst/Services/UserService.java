package com.gst.Services;


import com.gst.Model.User;
import com.gst.Model.UserDetails;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);

    void saveUser(User user);
    void saveTrainer(User user, UserDetails userDetails);
    User findOne(int id);

    List<User> findAllUserActive();
    List<User> findAllbyEmail(String email);
    List<User> findAllByActive();
    void updatePassword(int id, User user);

    void deleteUser(int id);
}
