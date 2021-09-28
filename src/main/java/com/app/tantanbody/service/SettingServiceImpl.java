package com.app.tantanbody.service;

import com.app.tantanbody.mapper.SettingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService{

    private final SettingMapper settingMapper;

    @Override
    public Map<String, Object> getUserInfo(String userEmail) {
        return settingMapper.selectUserInfo(userEmail);
    }
}
