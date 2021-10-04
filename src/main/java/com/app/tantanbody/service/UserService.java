package com.app.tantanbody.service;

import com.app.tantanbody.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    public List<Map<String, Object>> getUserList();

    void saveUserData(UserDto userDto);

}
