package com.app.tantanbody.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

/**
 * 식단 화면 관련 DTO
 */
@Alias("dietDTO")
@Getter
@Setter
public class DietDto extends UserDto{

    private String userEmail; //fk

    private Integer foodNum;
    private String foodName;
    private Integer oneTimeProv; //1회 제공량
    private String unit; //1회 제공량 단위
    private Integer totalKcal; //총 칼로리
    private Timestamp eatDatm; //mysql Datetime == java Timestamp
    private Integer eatCount;

    private String sFoodName; //검색하는 음식명

    private List<DietDto> dietList;

}