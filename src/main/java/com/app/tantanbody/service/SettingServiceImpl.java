package com.app.tantanbody.service;

import com.app.tantanbody.mapper.SettingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl implements SettingService{

    private final SettingMapper settingMapper;


}
