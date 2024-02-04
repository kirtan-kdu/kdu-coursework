package com.kdu.smarthome.repository;

import com.kdu.smarthome.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {

}