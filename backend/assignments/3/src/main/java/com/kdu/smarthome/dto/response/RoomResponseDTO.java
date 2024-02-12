package com.kdu.smarthome.dto.response;


import com.kdu.smarthome.models.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponseDTO {
    private Room room;
    private String message;
    private HttpStatus httpStatus;
}
