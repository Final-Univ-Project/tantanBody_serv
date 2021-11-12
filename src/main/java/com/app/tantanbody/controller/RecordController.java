package com.app.tantanbody.controller;

import com.app.tantanbody.service.ExerciseService;
import com.app.tantanbody.service.WeightService;
import com.app.tantanbody.dto.ExerciseDto;
import com.app.tantanbody.dto.WeightDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
//@Component
@RequestMapping("/record")
public class RecordController {

    private final WeightService weightService; //체중 기록 관련 서비스
    private final ExerciseService exerciseService; // 운동 기록 관련 서비스

    /**
     * 운동
     */
    //user의 운동 기록 보여주기 (일주일치)
    @ResponseBody
    @PostMapping("/exercise")
    public List<Map<String, Object>> getId(@RequestBody String userEmail) {
        return weightService.getId(userEmail);
    }

    //운동기록 추가 (running_time)
    @ResponseBody
    @PostMapping("/exercise/insert")
    public String insertExercise(@RequestBody ExerciseDto exerciseDto) {
        exerciseService.insertExercise(exerciseDto);
        return "/record/exercise/insert";
    }

    //운동 기록 수정
    @ResponseBody
    @PatchMapping("/exercise/up")
    public String updateExercise(@RequestBody ExerciseDto exerciseDto) {
        exerciseService.updateExercise(exerciseDto);
        return "/record/exercise/up";
    }

    /**
     * 체중
     */
    //user의 몸무게 보여주기 (일주일치)
    @ResponseBody
    @PostMapping("/weight")
    public List<Map<String, Object>> getWeight(@RequestBody String userEmail) {
        return weightService.getWeight(userEmail);
    }

    //몸무게 추가
    @ResponseBody
    @PostMapping("/weight/insert")
    public String insertWeight(@RequestBody WeightDto weightDto) {
        weightService.insertWeight(weightDto);
        return "/record/weight/in";
    }

    //몸무게 수정
    @ResponseBody
    @PatchMapping("/weight/up")
    public String updateWeight(@RequestBody WeightDto weightDto) {
        weightService.updateWeight(weightDto);
        return "/record/weight/up";
    }

}