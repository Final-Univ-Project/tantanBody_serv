package com.app.tantanbody.service;

import com.app.tantanbody.dto.WeightDto;

import java.util.List;
import java.util.Map;

public interface WeightService {

    List<Map<String,Object>> getId(String userEmail);

    List<Map<String,Object>> getWeight(String userEmail);

    void insertWeight(WeightDto weightDto);

    void updateWeight(WeightDto weightDto);

}
