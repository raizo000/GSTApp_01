package com.gst.JunitTest;

import com.gst.Repository.UserDetailsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@RunWith(SpringRunner.class)
public class UserDetailsRepositoryTest {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Test
    public void deleteUserDetails() {
        userDetailsRepository.deleteUserDetails(1);

        assertNull(userDetailsRepository.findByUser_idAndActive(1, 1));
    }
}
