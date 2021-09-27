package com.app.tantanbody.service;

import com.app.tantanbody.dto.DietDto;

import java.util.List;
import java.util.Map;

public interface DietService {

    public List<Map<String, Object>> getDiets(String userEmail);

    public List<Map<String, Object>> getFoodList();

    public DietDto saveDiet(DietDto dietDto);

    List<Map<String, Object>> getRecentFoods();
}
