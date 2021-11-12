package com.app.tantanbody.service;

import com.app.tantanbody.dto.ExerciseDto;

import java.util.List;
import java.util.Map;

public interface ExerciseService {

    List<Map<String, Object>> getFavExercise(String userEmail);

    void saveVideo(ExerciseDto exerciseDto);

    void saveExerRecord(ExerciseDto exerciseDto);

    void saveFavVideo(ExerciseDto exerciseDto);

    void delFavVideo(String userEmail, String videoId);

    /////////////////
    List<Map<String, Object>> getId(String userEmail);

    void insertExercise(ExerciseDto exerciseDto);

    void updateExercise(ExerciseDto exerciseDto);
}
