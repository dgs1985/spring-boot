package com.api.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
       
    public User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id > :id")
    public List<User> findAllMoreThan(@Param("id") Long id);

    public List<User> findByIdGreaterThan(Long id);

    public List<User> findByName(String name);

    public List<User> findByNameIgnoreCase(String name);
}
