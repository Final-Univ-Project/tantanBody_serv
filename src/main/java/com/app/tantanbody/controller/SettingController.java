package com.app.tantanbody.controller;

import com.app.tantanbody.service.SettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/setting")
    public Map<String, Object> getUserInfo(@RequestParam(name = "userEmail") String userEmail){
        return settingService.getUserInfo(userEmail);
    }

}
