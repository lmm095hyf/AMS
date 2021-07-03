package com.yc.ams.controller;

import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.CourseDao;
import com.yc.ams.db.dao.StuCourseDao;
import com.yc.ams.db.pojo.Course;
import com.yc.ams.db.pojo.StuCourse;
import com.yc.ams.utils.ResultResponse;
import com.yc.ams.utils.ResultTypeEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-04 21:08
 */
@RestController
@RequestMapping("course")
public class courseController {


    @Resource
    CourseDao courseDao;

    @Resource
    StuCourseDao stuCourseDao;
    //增加课目
    @RequestMapping("add")
    public ResultResponse addMajor(Course course){
        courseDao.insert(course);
        System.out.println(course);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {
        Map<String, Object> so = new HashMap<String, Object>();
        List<Course> ls = courseDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);
        return so;
    }

    @RequestMapping("/Selshow")
    public Map<String, Object> showtable2() {
        Map<String, Object> so = new HashMap<String, Object>();
        List<StuCourse> ls = stuCourseDao.selSc();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);
        return so;
    }
}
