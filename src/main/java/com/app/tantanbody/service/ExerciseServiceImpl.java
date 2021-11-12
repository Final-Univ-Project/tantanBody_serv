package com.app.tantanbody.service;

import com.app.tantanbody.dto.ExerciseDto;
import com.app.tantanbody.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseMapper exerciseMapper;

    @Override
    public List<Map<String, Object>> getFavExercise(String userEmail) {
        return exerciseMapper.selectFavExercise(userEmail);
    }

    @Override
    public void saveVideo(ExerciseDto exerciseDto) {
        exerciseMapper.insertVideo(exerciseDto);
    }

    @Override
    public void saveExerRecord(ExerciseDto exerciseDto) {
        exerciseMapper.insertExerRecord(exerciseDto);
    }

    @Override
    public void saveFavVideo(ExerciseDto exerciseDto) {
        exerciseMapper.insertFavVideo(exerciseDto);
    }

    @Override
    public void delFavVideo(String userEmail, String videoId) {
        exerciseMapper.deleteFavVideo(userEmail, videoId);
    }

    @Override
    public List<Map<String,Object>> getId(String userEmail) {
        return exerciseMapper.getId(userEmail);
    }
}
