package com.app.tantanbody.service;

import com.app.tantanbody.dto.UserDto;
import com.app.tantanbody.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getUserList() {
        log.info("====== info getUserList ::: started");
        return userMapper.getUserList();
    }

    @Override
    public void saveUserDate(UserDto userDto) {
        userMapper.insertUserDate(userDto);
    }

}
