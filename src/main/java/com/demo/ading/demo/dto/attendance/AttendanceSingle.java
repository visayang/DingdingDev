package com.demo.ading.demo.dto.attendance;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttendanceSingle {
    public AttendanceSingle(String personName,  String eventFirstTime, String eventLastTime) {
        this.personName = personName;
        this.eventFirstTime = eventFirstTime;
        this.eventLastTime = eventLastTime;
    }

    private String personName;



    //触发打卡时间 当日第一次
    private String eventFirstTime="未查询到刷卡记录";

    //触发打卡时间 当日最后一次
    private String eventLastTime="未查询到刷卡记录";

    public AttendanceSingle(String personName, String eventFirstTime) {
        this.personName = personName;
        this.eventFirstTime = eventFirstTime;
    }

    @Override
    public String toString() {
        return "AttendanceSingle{" +
                "personName='" + personName + '\'' +
                ", eventFirstTime='" + eventFirstTime + '\'' +
                ", eventLastTime='" + eventLastTime + '\'' +
                '}';
    }
}
