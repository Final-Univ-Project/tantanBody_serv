package com.app.tantanbody.service;

import com.app.tantanbody.dto.DietDto;
import com.app.tantanbody.mapper.DietMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService{

    private final DietMapper dietMapper;

    @Override
    public List<Map<String, Object>> getDiets() {
        return dietMapper.selectDiets();
    }

    @Override
    public List<Map<String, Object>> getFoodList() {
        return dietMapper.selectFoodList();
    }

    @Override
    public DietDto saveDiet(DietDto dietDto) {
        dietDto.setEatDatm(dietDto.getEatDatm());
        dietDto.setUserEmail(dietDto.getUserEmail());
        dietDto.setEatCount(dietDto.getEatCount());
        dietDto.setTotalKcal(dietDto.getTotalKcal());
        return dietMapper.insertDiet(dietDto);
    }
}
