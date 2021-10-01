package com.app.tantanbody.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("userDTO")
@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    private String photo = null;
}
