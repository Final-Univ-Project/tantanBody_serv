package com.app.tantanbody.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DietDto {
    private Integer foodNum;
    private String foodName;
    private Integer oneTimeProv; //1회 제공량
    private String unit; //1회 제공량 단위
    private Integer totalKcal; //총 칼로리
}
