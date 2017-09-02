package com.gst.Services;


import com.gst.Model.User;
import com.gst.Model.UserDetails;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);

    User findOne(int id);

    UserDetails findTrainerDetails(int id);

    List<User> findTrainer();

    List<User> findAllUserActive();

    List<User> findAllbyEmail(String email);

    List<User> findAllByActive();

    List<User> findAllByToiec(String toiec);

    void saveUser(User user);

    void saveTrainer(User user, UserDetails userDetails);

    void updatePassword(int id, User user);

    void updateTrainerDetails(int id, UserDetails userDetails);

    void deleteUser(int id);
}
