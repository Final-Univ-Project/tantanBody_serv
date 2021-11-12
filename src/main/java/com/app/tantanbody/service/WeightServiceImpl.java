package com.app.tantanbody.service;

import com.app.tantanbody.dto.WeightDto;
import com.app.tantanbody.mapper.WeightMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeightServiceImpl {

    private final WeightMapper weightMapper;

    @Override
    public List<Map<String,Object>> getId(String userEmail) {
        log.info("getId");
        return weightMapper.getId(userEmail);
    }

    @Override
    public List<Map<String,Object>> getWeight(String userEmail) {
        return weightMapper.getWeight(userEmail);
    }

    @Override
    public void insertWeight(WeightDto weightDto) {
        weightDto.setUserEmail(weightDto.getUserEmail());
        weightDto.setWeight(weightDto.getWeight());
        weightDto.setW_Date(weightDto.getW_Date());
        weightMapper.insertWeight(weightDto);
    }

    @Override
    public void updateWeight(WeightDto weightDto) {

    }
}
