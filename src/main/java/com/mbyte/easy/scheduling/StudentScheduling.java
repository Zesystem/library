package com.mbyte.easy.scheduling;

import com.mbyte.easy.student.service.IStudentService;
import com.mbyte.easy.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @ClassName StudentScheduling
 * @Description 扫描是否超过两个月没还书
 * @Author 戴书博
 * @Date 2019/11/16 0:01
 * @Version 1.0
 **/
@Slf4j
@Component
public class StudentScheduling {

    @Autowired
    private IStudentService studentService;

    /**
     * @Method scheduling
     * @Author 戴书博
     * @Description 扫描是否超过两个月没还书,超过天数
     * @Return void
     * @Date 2019/11/16 0:06
     * @Version  1.0
     */
    @Scheduled(fixedRate = 1000 * 60 * 60 * 24)
    public void scheduling(){
        log.info("=========>  定时任务");
        studentService.scheduling();
    }
}
