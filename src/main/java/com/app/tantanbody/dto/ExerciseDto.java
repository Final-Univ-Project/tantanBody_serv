package com.app.tantanbody.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ExerciseDto extends UserDto{

    // 공통
    private String videoId;

    //exercise_video
    private String channelTitle; //채널명
    private String thumbnail;
    private String videoTitle; //영상제목
    private int playTime;
    private Timestamp uploadDate;
    private String keyword; //TODO 이게 쭉 들어온다고 가정하면 split()이 필요할수도

    //exercise_record
    private Timestamp exerciseDate;
    private String runningTime; //영상 시청 시간

    //favorite_exercise
    private Timestamp registeredDate;

    private List<ExerciseDto> videoList;
}
