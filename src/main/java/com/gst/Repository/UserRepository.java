package com.gst.Repository;

import com.gst.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByActive(int active);
    List<User> findAllByEmail(String email);
    User findByEmail(String email);

    @Modifying
    @Query("Update User set password=:password where id=:id")
    void updatePassword(@Param("id") int id, @Param("password") String password);

    @Modifying
    @Query("Update User set active=2 where id=:id")
    void deleteUser(@Param("id") int id);
}
