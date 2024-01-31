package org.kdu.homework.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestGlobalDTO {

    private UUID tenantId;
    private UUID userId;
    private UUID shiftTypeId;
    private UUID shiftId;

    private String createdBy;

    private String userName;
    private short loggedIn;
    private String timeZone;

    private String shiftName;//
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;

    private String shiftTypeName;//
    private String description;
    private boolean active;



}
