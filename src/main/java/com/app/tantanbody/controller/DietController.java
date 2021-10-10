package com.app.tantanbody.controller;

import com.app.tantanbody.dto.DietDto;
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

    private final DietService dietService;

    /**
     * localhost:8080/diet
     * 식단 메인 화면에서 지금까지 기록했던 식단들 볼 수 있음
     * 해당 사용자의 식단만 봐야하기 때문에 파라미터로 현재 사용자의 이메일을 넘김
     * @return List<Map<String, Object>>
     */
    @ResponseBody
    @PostMapping
    public List<Map<String, Object>> getDiets(@RequestBody String userEmail){
        return dietService.getDiets(userEmail);
    }

    /**
     * localhost:8080/diet/w/search
     * 사용자가 최근 검색했던 음식명 리스트를 보여줌
     * @return
     */
    @ResponseBody
    @PostMapping("/w/search")
    public List<Map<String, Object>> getRecentFoods(@RequestBody String userEmail){
        return dietService.getRecentFoods(userEmail);
    }
    /*@GetMapping("/w/search")
    public List<Map<String, Object>> getRecentFoods(@RequestParam(name = "userEmail") String userEmail){
        return dietService.getRecentFoods(userEmail);
    }*/

    /**
     * localhost:8080/diet/w/search/foodList
     * 식단 추가 화면에서 검색한 음식명과 관련된 음식 가져옴
     * like 구문 필요
     * @param sFoodName
     * @return
     */
    @ResponseBody
    @PostMapping("/w/search/foodList")
    public List<Map<String, Object>> searchFoodList(@RequestBody String sFoodName){
        log.info("검색할 음식 명 >>> {}", sFoodName);
        //log.info("dietService.searchFoodList(sFoodName) >>>>> {}", dietService.searchFoodList(sFoodName));
        try{
            // TODO 사용자 정보도 검색한 음식에 저장할 때 넣어야 함... 사용자 이메일이랑 음식이름을 넘겨야 함
            //dietService.saveSearchFood(dietDto); //검색한 음식 저장
            return dietService.searchFoodList(sFoodName); //검색한 음식명을 가진 모든 음식 불러옴
        } catch (Exception e){
            return null;
        }
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
