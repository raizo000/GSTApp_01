package com.gst.Repository;

import com.gst.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    @Modifying
    @Query("update UserDetails  set active=2 where user_id=:user_id")
    void deleteUserDetails(@Param("user_id") int user_id);

    @Modifying
    @Query("update  UserDetails  set last_name=:last_name, first_name=:first_name,experience=:experience," +
            "location=:location,program_language=:program_language,education=:education, birthday=:birthday where user_id=:user_id")
    void saveDetails(@Param("last_name") String last_name, @Param("first_name") String first_name,
                     @Param("experience") String experience, @Param("location") String location,
                     @Param("education") String education, @Param("program_language") String program_language,
                     @Param("birthday") String birthday,
                     @Param("user_id") int user_id);

    List<UserDetails> findAllByActive(int active);

    UserDetails findUserDetailsByUser_id(int id);
}