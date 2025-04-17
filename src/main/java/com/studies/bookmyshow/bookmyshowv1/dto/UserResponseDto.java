package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
}
