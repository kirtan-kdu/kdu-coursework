package org.kdu.homework.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTime {
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String  createdBy;
    private String  updatedBy;
}
