package com.demo.ading.demo.controller;

import com.demo.ading.demo.dto.*;
import com.demo.ading.demo.dto.attendance.AttendanceSingle;
import com.demo.ading.demo.service.DingAuthService;
import com.demo.ading.demo.service.DingUserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/ding")
public class UserController {
    static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private DingAuthService dingAuthService;

    @Autowired
    private DingUserService dingUserService;

    /**
     * 根据前台初始化后获取的免登授权码获取用户信息
     *
     * @param code   免登授权码
     * @param corpId 企业应用corpId
     * @return
     */
    @GetMapping("/login")
    public Map<String,Object> authCodeLogin(@RequestParam("code") String code,
                                            @RequestParam("corpId") String corpId) {
        DingAccessTokenDTO accessTokenDTO = dingAuthService.accessToken();
        DingUserIdDTO userIdDTO = dingUserService.getUserId(accessTokenDTO.getAccess_token(), code);
        DingUserDTO userInfo = dingUserService.getUserInfo(accessTokenDTO.getAccess_token(), userIdDTO.getUserid());


        Map<String, Object> result = new LinkedHashMap<>();
        result.put("code", code);
        result.put("token", accessTokenDTO.getAccess_token());

        result.put("user", userInfo);
        result.put("corpId", corpId);

        log.debug("[钉钉] 用户免登, 根据免登授权码code, corpId获取用户信息, code: {}, corpId:{}, result:{}", code, corpId, result);

        logger.info(result.toString());

        return result;
    }

    /**
     * 根据人名查询当日的考勤
     * @param personName  被查询人的系统的姓名
     * @return
     */
    @GetMapping("/getAttendanceTodaySelf")
    public Map<String, AttendanceSingle> getAttendanceDataTodaySelf(@RequestParam("personName") String personName,@RequestParam("queryDate") String queryDate){
        AttendanceSingle ycg = new AttendanceSingle(personName,
                "2020-05-11 08:14:54","2020-05-11 12:13:22");

        Map<String, AttendanceSingle> map = new HashMap<>();
        map.put("self",ycg);
        return map;
    }

    public String dateFormatChange(String datas) {
        LocalDateTime date = LocalDateTime.parse(datas, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        return dateString;
    }


}
