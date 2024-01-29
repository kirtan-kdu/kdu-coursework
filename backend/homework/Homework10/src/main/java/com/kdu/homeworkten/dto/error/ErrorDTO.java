package com.kdu.homeworkten.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private int httpStatus;
}
