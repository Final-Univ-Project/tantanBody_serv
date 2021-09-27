package com.app.tantanbody.controller;

import com.app.tantanbody.dto.UserDto;
import com.app.tantanbody.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor //final이나 @NonNull이 붙은 필드에 생성자 생성(생성자 주입 사용) -- @Autowired를 사용한 필드 주입 피하기 위함
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public Object test(){
        return "hello";
    }

    /**
     * localhost:8080/users
     * 저장되어 있는 user의 정보를 가져옴
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Map<String, Object>> getUser(){
        return userService.getUserList();
    }


}
