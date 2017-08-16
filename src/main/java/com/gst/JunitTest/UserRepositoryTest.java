package com.gst.JunitTest;

import com.gst.Model.User;
import com.gst.Repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @org.junit.Test
    public void findbyName() throws Exception {

        User user = userRepository.findByEmail("admin@gmail.com");
        assertEquals("admin@gmail.com", user.getEmail());
    }

    @org.junit.Test
    public void findAllActive() throws Exception {
        List<User> users = userRepository.findAllByActive(2);

    }


}





