package com.app.tantanbody.mapper;

import com.app.tantanbody.dto.ExerciseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ExerciseMapper {

    List<Map<String, Object>> selectFavExercise(String userEmail);

    void insertVideo(ExerciseDto exerciseDto);

    void insertExerRecord(ExerciseDto exerciseDto);

    void insertFavVideo(ExerciseDto exerciseDto);

    void deleteFavVideo(String userEmail, String videoId);

}
