package com.app.tantanbody.service;

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
    public List<Map<String, Object>> getFoodList() {
        return dietMapper.selectFoodList();
    }
}
