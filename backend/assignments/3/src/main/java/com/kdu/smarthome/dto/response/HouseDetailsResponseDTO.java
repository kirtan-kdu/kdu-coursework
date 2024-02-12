package com.kdu.smarthome.dto.response;

import com.kdu.smarthome.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class HouseDetailsResponseDTO {
    private List<User> userList;
    private String roomsAndDevices;
    private HttpStatus httpStatus;
}
