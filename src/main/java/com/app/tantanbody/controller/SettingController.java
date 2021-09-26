package com.app.tantanbody.controller;

import com.app.tantanbody.service.SettingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;


}
