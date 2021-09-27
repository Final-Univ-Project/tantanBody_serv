package com.app.tantanbody.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

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


}
