package com.app.tantanbody.controller;

import com.app.tantanbody.dto.DietDto;
import com.app.tantanbody.service.DietService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController //내부적으로 Jackson 라이브러리에 의해 dto 객체를 json 형태로 변환하여 응답
@RequiredArgsConstructor
@RequestMapping("/diet") //이 url을 고정으로 함
public class DietController {

    private final DietService dietService;

    /**
     * localhost:8080/diet/lists
     * 식단 메인 화면에서 지금까지 기록했던 식단들 볼 수 있음
     * 해당 사용자의 식단만 봐야하기 때문에 파라미터로 현재 사용자의 이메일을 넘김
     * @return List<Map<String, Object>>
     */
    @GetMapping("/lists")
    public List<Map<String, Object>> getDiets(@RequestParam(name = "userEmail") String userEmail){
        return dietService.getDiets(userEmail);
    }

    /**
     * localhost:8080/search
     * 최근 검색했던 음식 리스트 뽑아옴
     * @return
     */
    @GetMapping("/search")
    public List<Map<String, Object>> getRecentFoods(){
        return dietService.getRecentFoods();
    }

    /**
     * localhost:8080/diet/foodList
     * 식단 추가 화면에서 검색 버튼 누르면 음식 리스트 쭉 가져옴
     * @return List<Map<String, Object>>
     */
    @GetMapping("/search/foodList")
    public List<Map<String, Object>> getFoodList(){
        return dietService.getFoodList();
    }

    /**
     * localhost:8080/diet/save
     * 식단 저장
     * @param dietDto
     * @return DietDto
     */
    @ResponseBody
    @PostMapping("/save")
    public DietDto saveDiet(@RequestBody DietDto dietDto){
        log.info("foodNum={}, userEmail={}, eatDatm={}, eatCount={}, totalKcal={}",
                dietDto.getFoodNum(), dietDto.getUserEmail(), dietDto.getEatDatm(), dietDto.getEatCount(), dietDto.getTotalKcal());
        return dietService.saveDiet(dietDto);
    }

}
