package org.kdu.homework.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends UpdateTime {

    private UUID id;
    private String userName;
    private short loggedIn;
    private String timeZone;
    private UUID tenantId;

}
