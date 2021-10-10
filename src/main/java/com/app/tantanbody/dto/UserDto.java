package com.app.tantanbody.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("userDTO")
@Getter
@Setter
public class UserDto {
    private String userEmail;
    private String userName;
    private String photo = null;
    private String goal; //운동 목표
}
