package com.demo.ading.demo.dto;

public class DingResponse {
    /**
     * errcode : 0
     * task_id : 174248049425
     * request_id : 2refjhn76rku
     */

    public int errcode;
    public long task_id;
    public String request_id;

    @Override
    public String toString() {
        return "DingResponse{" +
                "errcode=" + errcode +
                ", task_id=" + task_id +
                ", request_id='" + request_id + '\'' +
                '}';
    }
}
