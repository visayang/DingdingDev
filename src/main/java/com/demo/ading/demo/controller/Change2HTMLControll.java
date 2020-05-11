package com.demo.ading.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class Change2HTMLControll {
    Logger logger = LoggerFactory.getLogger(Change2HTMLControll.class);

    /**
     * @param map 考勤页面
     * @return
     */
    @RequestMapping(value = "/attendance", method = RequestMethod.GET)
    public String helloAttendance(HashMap<String, Object> map, Model model, @RequestParam(value = "loginUserPhone", required = false) String loginUserPhone, HttpServletRequest request) {
        map.put("loginUserName", "诗歌远方");
        return "attendance";
    }
}