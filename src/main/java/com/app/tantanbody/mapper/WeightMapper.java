package com.app.tantanbody.mapper;

import com.app.tantanbody.dto.WeightDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface WeightMapper {
    List<Map<String, Object>> getId(String userEmail);

    List<Map<String,Object>> getWeight(String userEmail);

    void insertWeight(WeightDto weightDto);

    void updateWeight(WeightDto weightDto);
}
