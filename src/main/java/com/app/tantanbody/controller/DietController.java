package com.app.tantanbody.controller;

import com.app.tantanbody.dto.DietDto;
import com.app.tantanbody.service.DietService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/diet") //이 url을 고정으로 함
public class DietController {

    private final DietService dietService;

    /**
     * localhost:8080/diet/lists
     * 식단 메인 화면에서 지금까지 기록했던 식단들 볼 수 있음
     * @return
     */
    @GetMapping("/lists")
    public List<Map<String, Object>> getDiets(){
        return dietService.getDiets();
    }


    /**
     * localhost:8080/diet/foodList
     * 식단 추가 화면에서 '+' 버튼 누르면 식단 리스트 쭉 가져옴
     * @return List<Map<String, Object>>
     */
    @GetMapping("/foodList")
    public List<Map<String, Object>> getFoodList(){
        return dietService.getFoodList();
    }

    /**
     * localhost:8080/diet/save
     * 식단 저장
     * @param dietDto
     * @return
     */
    @ResponseBody
    @PostMapping("/save")
    public DietDto saveDiet(@RequestBody DietDto dietDto){
        log.info("foodNum={}, userEmail={}, eatDatm={}, eatCount={}, totalKcal={}",
                dietDto.getFoodNum(), dietDto.getUserEmail(), dietDto.getEatDatm(), dietDto.getEatCount(), dietDto.getTotalKcal());
        return dietService.saveDiet(dietDto);
    }


}
