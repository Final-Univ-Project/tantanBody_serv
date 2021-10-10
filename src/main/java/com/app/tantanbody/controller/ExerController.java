package com.app.tantanbody.controller;

import com.app.tantanbody.service.ExerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExerController {

    private final ExerService exerService;

}
