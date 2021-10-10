package com.app.tantanbody.controller;

import com.app.tantanbody.dto.ExerciseDto;
import com.app.tantanbody.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    /**
     * 운동 화면에 처음 들어가면 사용자가 즐겨찾기 한 운동이 나와야 함
     * @param userEmail
     * @return List<Map<String, Object>>
     */
    @ResponseBody
    @PostMapping
    public List<Map<String, Object>> getFavExercise(@RequestBody String userEmail){
        try{
            log.info("===== 사용자의 즐겨찾기 운동 리스트 가져오기");
            return exerciseService.getFavExercise(userEmail);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 운동 영상을 클릭만 한 경우 운동 영상 정보를 저장해야 함
     * @param exerciseDto
     * @return
     */
    @ResponseBody
    @PostMapping("/video")
    public String saveVideo(@RequestBody ExerciseDto exerciseDto){
        try {
            exerciseService.saveVideo(exerciseDto);

            return "OK";
        } catch (Exception e){
            return "ERR";
        }
    }

    /**
     * 운동을 끝내면 운동한 기록들을 개인 기록에 남겨야 함
     * @param exerciseDto
     * @return
     */
    @ResponseBody
    @PostMapping("/record")
    public String saveExerRecord(@RequestBody ExerciseDto exerciseDto){
        try{
            exerciseService.saveExerRecord(exerciseDto);

            return "OK";
        } catch (Exception e){
            return "ERR";
        }
    }

    /**
     * 운동영상을 즐겨찾기에 등록한 경우 (롱 클릭)
     * @param exerciseDto
     * @return
     */
    @ResponseBody
    @PostMapping("/favVideo")
    public String saveFavVideo(@RequestBody ExerciseDto exerciseDto){
        try {
            log.info("===== 운동을 즐겨찾기에 등록 요청... videoId={}", exerciseDto.getVideoId());

            exerciseService.saveVideo(exerciseDto);
            log.info("===== exercise_video 에 값을 먼저 저장");

            exerciseService.saveFavVideo(exerciseDto);
            log.info("===== favorite_exercise 에 값 저장");

            return "OK";
        } catch (Exception e){
            return "ERR";
        }
    }

    /**
     * 즐겨찾기에서 videoId값을 가진 데이터를 삭제
     * userEmail이 path에 노출되는건 치명적이지만 delete가 RequestBody를 허용 안한다고...(https://sjh836.tistory.com/142)
     * @param videoId
     * @return
     */
    @DeleteMapping("/favVideo/{userEmail}/{videoId}")
    public String delFavVideo(@PathVariable String userEmail, @PathVariable String videoId){
        try {
            log.info("===== 운동 즐겨찾기 삭제 요청... userEmail={}, videoId={}", userEmail, videoId);
            exerciseService.delFavVideo(userEmail, videoId);

            return "OK";
        } catch (Exception e){
            return "ERR";
        }
    }

}
