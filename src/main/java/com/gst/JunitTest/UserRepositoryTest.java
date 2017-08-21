package com.gst.JunitTest;

import com.gst.Model.User;
import com.gst.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = " com.gst.SecurityConfig")
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Qualifier("Password")
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void findbyName() throws Exception {

        User user = userRepository.findByEmail("admin@gmail.com");
        assertEquals("admin@gmail.com", user.getEmail());
    }

    @Test
    public void findAllActive() throws Exception {
        ArrayList<User> a = new ArrayList<>();
        List<User> users = userRepository.findAllByActive(3);
        assertEquals(a, users);
    }

    @Test
    public void updatePassword() throws Exception {
        userRepository.updatePassword(1, bCryptPasswordEncoder.encode("1234567899"), 1);

        User user = userRepository.findByEmail("admin@gmail.com");
        assertTrue(bCryptPasswordEncoder.matches("1234567899", user.getPassword()));
    }

    @Test
    public void deleteUser() throws Exception {
        userRepository.deleteUser(1);
        User user = userRepository.findByActiveAndEmail(1, "admin@gmail.com");
        assertNull(user);
    }
}





