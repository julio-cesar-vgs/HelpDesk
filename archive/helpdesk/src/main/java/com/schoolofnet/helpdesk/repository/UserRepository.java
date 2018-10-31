package com.schoolofnet.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolofnet.helpdesk.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
