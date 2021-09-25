package com.app.tantanbody.service;

import com.app.tantanbody.dto.UserDto;
import com.app.tantanbody.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getUserList() {
        return userMapper.getUserList();
    }
}
