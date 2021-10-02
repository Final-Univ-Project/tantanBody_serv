package com.app.tantanbody.controller;

import com.app.tantanbody.dto.DietDto;
import com.app.tantanbody.dto.UserDto;
import com.app.tantanbody.service.DietService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 식단 화면
 */
@Slf4j
@RestController //내부적으로 Jackson 라이브러리에 의해 dto 객체를 json 형태로 변환하여 응답
@RequiredArgsConstructor
@RequestMapping("/diet") //이 url을 고정으로 함
public class DietController {

    // TODO 최근 검색 결과를 언제 저장해야 하는 것인가??? 저장 시기 생각할 필요 있음

    private final DietService dietService;

    /**
     * localhost:8080/diet
     * 식단 메인 화면에서 지금까지 기록했던 식단들 볼 수 있음
     * 해당 사용자의 식단만 봐야하기 때문에 파라미터로 현재 사용자의 이메일을 넘김
     * @return List<Map<String, Object>>
     */
    @GetMapping
    public List<Map<String, Object>> getDiets(@RequestParam(name = "userEmail") String userEmail){
        return dietService.getDiets(userEmail);
    }

    /*@ResponseBody
    @PostMapping
    public DietDto getDiets(@RequestBody String userEmail){
        return dietService.getDiets(userEmail);
    }*/

    /**
     * localhost:8080/diet/w/search
     * 사용자가 최근 검색했던 음식 리스트를 보여줌
     * 음식명, 1회 제공량(단위도), 칼로리
     * @return
     */
    @GetMapping("/w/search")
    public List<Map<String, Object>> getRecentFoods(@RequestParam(name = "userEmail") String userEmail){
        return dietService.getRecentFoods(userEmail);
    }

    /**
     * localhost:8080/diet/w/search/foodList
     * 식단 추가 화면에서 검색한 음식명과 관련된 음식 가져옴
     * like 구문 필요
     * @param sFoodName
     * @return
     */
    @GetMapping("/search/foodList")
    public List<Map<String, Object>> searchFoodList(@RequestParam(name = "sFoodName") String sFoodName){
        return dietService.searchFoodList(sFoodName);
    }

    /**
     * localhost:8080/diet/w/save
     * 식단 저장
     * @param dietDto
     * @return String
     */
    @ResponseBody
    @PostMapping("/w/save")
    public String saveDiet(@RequestBody DietDto dietDto){
        try{
            List<DietDto> aaa = dietDto.getDietList();
            int i = 0;

            for(DietDto dietList : aaa){
                log.info("INSERT execute >>>>> foodNum={}, userEmail={}, eatCount={}, totalKcal={}",
                        dietList.getFoodNum(), dietList.getUserEmail(), dietList.getEatCount(), dietList.getTotalKcal());
                dietService.saveDiet(dietList);
                i++;
            }

            return "OK";
        } catch (Exception e) {
            return "ERR";
        }
    }

}
