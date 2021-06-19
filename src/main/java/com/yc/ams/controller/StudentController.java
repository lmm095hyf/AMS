package com.yc.ams.controller;

import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.StudentDao;
import com.yc.ams.db.dao.TeacherDao;
import com.yc.ams.db.pojo.Student;
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
 * @create: 2021-06-06 16:02
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentDao studentDao;
    //增加系部
    @RequestMapping("add")
    public ResultResponse addDepart(Student student){

        studentDao.insert(student);
        System.out.println(student);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {

        Map<String, Object> so = new HashMap<String, Object>();

        List<Student> ls = studentDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);

        return so;
    }
}
