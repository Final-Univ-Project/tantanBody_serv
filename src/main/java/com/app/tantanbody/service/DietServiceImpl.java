package com.app.tantanbody.service;

import com.app.tantanbody.dto.DietDto;
import com.app.tantanbody.mapper.DietMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class DietServiceImpl implements DietService{

    private final DietMapper dietMapper;

    @Override
    public List<Map<String, Object>> getDiets(String userEmail) {
        log.info("===== getDiets ::: start");
        return dietMapper.selectDiets(userEmail);
    }

    /*@Override
    public List<Map<String, Object>> getRecentFoods(String userEmail) {
        return dietMapper.selectRecentFoods(userEmail);
    }*/
    @Override
    public String[] getRecentFoods(String userEmail) {
        return dietMapper.selectRecentFoods(userEmail);
    }

    @Override
    public List<Map<String, Object>> searchFoodList(String sFoodName) {
        return dietMapper.selectFoodList(sFoodName);
    }

    /*@Override
    public void saveSearchFood(DietDto dietDto) {
        dietMapper.insertSearchFood(dietDto);
    }*/

    @Override
    public void saveDiet(DietDto dietDto) {
        dietDto.setEatDatm(dietDto.getEatDatm());
        dietDto.setUserEmail(dietDto.getUserEmail());
        dietDto.setEatCount(dietDto.getEatCount());
        dietDto.setTotalKcal(dietDto.getTotalKcal());
        dietDto.setDietList(dietDto.getDietList());
        dietMapper.insertDiet(dietDto);
    }


}
