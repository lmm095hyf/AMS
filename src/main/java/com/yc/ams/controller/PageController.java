package com.yc.ams.controller;

import com.yc.ams.db.dao.DepartmentDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-08 21:10
 */
@RestController
public class PageController {

    @Resource
    DepartmentDao departmentDao;

    // 系部信息查看
    @RequestMapping("/departmentinfo")
    public String departmentinfo(Integer deid, Model model){
        model.addAttribute("departmentinfo",departmentDao.selectStudentInfoById(deid));
        return "departmentinfo";
    }
    // 系部信息修改
    @RequestMapping("/departmentinfoupdate")
    public String departmentInfoUpdate(Integer deid, Model model){

        model.addAttribute("deid",deid);
        return "studentinfoupdate";
    }
}
