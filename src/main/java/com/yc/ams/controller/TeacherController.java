package com.yc.ams.controller;

import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.TeacherDao;
import com.yc.ams.db.pojo.Department;
import com.yc.ams.db.pojo.Teacher;
import com.yc.ams.utils.ResultResponse;
import com.yc.ams.utils.ResultTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-06 14:48
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherDao teacherDao;
    //增加系部
    @RequestMapping("add")
    public ResultResponse addDepart(Teacher teacher){

        teacherDao.insert(teacher);
        System.out.println(teacher);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {

        Map<String, Object> so = new HashMap<String, Object>();

        List<Teacher> ls = teacherDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);

        return so;
    }
}
