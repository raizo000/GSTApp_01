package com.gst.Services;

import com.gst.Model.User;
import com.gst.Model.UserDetails;
import com.gst.Repository.UserDetailsRepository;
import com.gst.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

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
            userDetails.setActive(1);
            userDetailsRepository.save(userDetails);
        }
        userRepository.save(user);
    }

    @Override
    public List<User> findAllByActive() {
        return userRepository.findAllByActive(1);
    }

    @Override
    public List<User> findTrainer() {
        return userRepository.findAllByActiveAndRoleId(1, 3);
    }

    @Override
    public void saveTrainer(User user, UserDetails userDetails) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        userDetails.setActive(1);
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
    public UserDetails findTrainerDetails(int id) {
        return userDetailsRepository.findUserDetailsByUser_id(id);
    }

    @Override
    public void updateTrainerDetails(int id, UserDetails userDetails) {
        userDetailsRepository.saveDetails(userDetails.getLast_name(), userDetails.getFirst_name(),
                userDetails.getExperience(), userDetails.getLocation(), userDetails.getEducation(),
                userDetails.getProgram_language(), userDetails.getBirthday(), id);
    }

    @Override
    public void deleteUser(int id) {

        userRepository.deleteUser(id);
        userDetailsRepository.deleteUserDetails(id);
    }


}
