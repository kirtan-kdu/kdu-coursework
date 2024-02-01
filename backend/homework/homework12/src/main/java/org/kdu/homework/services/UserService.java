package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

import org.kdu.homework.entities.User;
import org.kdu.homework.exceptions.custom.CustomException;
import org.kdu.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new CustomException("Cannot add user. Please check the entity.");
        }
    }

    public List<User> getAllUsers(UUID tenantId) {
        List<User> userList;
        try {
            userList = userRepository.findAllByTenantId(tenantId);
        } catch (Exception e) {
            throw new CustomException("Invalid tenant id.");
        }
        return userList;
    }

    public void updateUser(UUID userId, User user) {
        try {
            if(userRepository.updateUserDetails(userId,user.getUsername(),user.getLoggedIn(),user.getTimeZone()) == 0){
                throw new CustomException("No users with given id.");
            }
            log.info("User updated successfully");
        } catch (Exception e) {
            throw new CustomException("Error while fetching error id");
        }
    }

    public Page<User> getAllUsersPagination(Pageable pageable){
        return userRepository.findAll(pageable);
    }

}
