package com.gst.Repository;

import com.gst.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    @Modifying
    @Query("update UserDetails  set active=2 where user_id=:user_id")
    void deleteUserDetails(@Param("user_id") int user_id);
}