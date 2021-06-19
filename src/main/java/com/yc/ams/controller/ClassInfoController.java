package com.yc.ams.controller;

import com.github.pagehelper.PageInfo;
import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.ClassinfoDao;
import com.yc.ams.db.dao.DepartmentDao;
import com.yc.ams.db.pojo.Classinfo;
import com.yc.ams.db.pojo.Department;
import com.yc.ams.service.UserService;
import com.yc.ams.utils.ResultResponse;
import com.yc.ams.utils.ResultTypeEnum;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: AMS
 * @description: 系部管理
 * @author: 作者 :林木木
 * @create: 2021-06-03 10:09
 */
@RestController
@RequestMapping("classinfo")
public class ClassInfoController extends BaseController{

    @Resource
    ClassinfoDao classinfoDao;

    //增加班级
    @RequestMapping("add")
    public ResultResponse addDepart(Classinfo classinfo){

        classinfoDao.insert(classinfo);
        System.out.println(classinfo);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {

        Map<String, Object> so = new HashMap<String, Object>();

        List<Classinfo> ls = classinfoDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);

        return so;
    }

}
