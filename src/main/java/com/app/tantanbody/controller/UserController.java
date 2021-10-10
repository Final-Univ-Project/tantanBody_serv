package com.app.tantanbody.controller;

import com.app.tantanbody.dto.UserDto;
import com.app.tantanbody.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor //final이나 @NonNull이 붙은 필드에 생성자 생성(생성자 주입 사용) -- @Autowired를 사용한 필드 주입 피하기 위함
public class UserController {

    private final UserService userService;

    /**
     * 192.168.10.27:8080/
     * 저장되어 있는 user의 정보를 가져옴
     * 가져와서 지금 사용하는 사용자 email이 있는지 확인해서 있으면 기존 사용자, 없으면 신규 사용자 판단 필요
     * 즉, 반환값이 list 가 아닌 string 으로 new, not new 등으로 표현할 필요 있음
     * @return List<Map<String, Object>>
     */
    @GetMapping("/")
    public List<Map<String, Object>> getUser(){
        return userService.getUserList();
    }

    /**
     * 사용자 검사
     * @param userDto
     * @return
     */
    @PostMapping("/login")
    public String saveUserData(@RequestBody UserDto userDto){
        try{
            if(userService.searchUser(userDto) == 0){ //신규 사용자는 user 정보를 저장해줘야 함
                log.info("신규 사용자 등록 ={}", userDto.getUserEmail());
                userService.saveUserData(userDto);
            }
            log.info("기존 사용자 입니다... ={}", userDto.getUserEmail());
            return "OK";
        } catch (Exception e){
            return "ERR";
        }
    }
}
