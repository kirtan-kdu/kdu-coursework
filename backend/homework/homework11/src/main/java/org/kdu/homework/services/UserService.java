package org.kdu.homework.services;

import lombok.extern.slf4j.Slf4j;
import org.kdu.homework.entities.User;
import org.kdu.homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UUID addUser(User user){
        log.info("User added" + user.toString());
        return userRepository.addUser(user);
    }

    public List<User> getAllUsers(UUID tenantId) {
        return userRepository.getAllUsers(tenantId);
    }

    public void updateUser(UUID userId, User user){
        userRepository.updateUser(userId, user);
        log.info("User updated" + user.toString());
    }
}
