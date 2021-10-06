package com.app.tantanbody.mapper;

import com.app.tantanbody.dto.DietDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DietMapper {

    List<Map<String, Object>> selectDiets(String userEmail);

    List<Map<String, Object>> getRecentFoods(String userEmail);

    List<Map<String, Object>> selectFoodList(String sFoodName);

    //void insertSearchFood(DietDto dietDto);

    void insertDiet(DietDto dietDto);

}
