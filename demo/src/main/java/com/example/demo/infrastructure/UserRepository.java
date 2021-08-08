package com.example.demo.infrastructure;

import com.example.demo.data.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    @Query(value = "SELECT username FROM ApplicationUser WHERE username =:username", nativeQuery = true)
    ApplicationUser findUserByUsername(@Param("username") String name);


}
