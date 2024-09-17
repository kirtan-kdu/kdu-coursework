package org.kdu.homework9.DTO.ErrorDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDTO {

    private String errorMsg;
    private HttpStatus status;

}
