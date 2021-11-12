
package com.app.tantanbody.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Alias("WeightDTO")
public class WeightDto extends UserDto{

    private String userEmail; //사용자(key)
    private Integer W_recordNum;
    private Double Weight; //몸무게
    private Timestamp w_Date; //입력?날짜

    private List<WeightDto> weightList;
}
