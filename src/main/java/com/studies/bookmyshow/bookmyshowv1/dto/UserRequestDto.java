package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;


}
