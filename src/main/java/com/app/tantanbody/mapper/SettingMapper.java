package com.app.tantanbody.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface SettingMapper {

    Map<String, Object> selectUserInfo(String userEmail);

}
