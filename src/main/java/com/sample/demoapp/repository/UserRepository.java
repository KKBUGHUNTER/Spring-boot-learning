package com.sample.demoapp.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sample.demoapp.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(String email);
    @Modifying
    @Transactional
    @Query("DELETE FROM UserModel u WHERE u.email = :email")
    void deleteByEmail(@Param("email") String email);
}
