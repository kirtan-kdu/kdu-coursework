package com.kdu.smarthome.services;

import com.kdu.smarthome.dto.request.LoginRequestDTO;
import com.kdu.smarthome.exceptions.custom.DuplicateEntryException;
import com.kdu.smarthome.exceptions.custom.UserNotFoundException;
import com.kdu.smarthome.models.User;
import com.kdu.smarthome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getByUserName(String username){
        try {
            return userRepository.findById(username);
        }
        catch (Exception e){
            throw new UserNotFoundException(e.getMessage());
        }
    }

    public void addUser(LoginRequestDTO loginRequestDTO){
        try {
            User user = User.builder().username(loginRequestDTO.getUsername())
                            .password(loginRequestDTO.getPassword())
                            .emailId(loginRequestDTO.getEmailId())
                            .lastName(loginRequestDTO.getLastName())
                            .name(loginRequestDTO.getName())
                            .firstName(loginRequestDTO.getFirstName()).build();
            userRepository.save(user);
        }
        catch (Exception exception){
            throw new DuplicateEntryException(exception.getMessage());
        }
    }
}
