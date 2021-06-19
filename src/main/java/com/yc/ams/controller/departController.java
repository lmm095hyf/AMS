package com.yc.ams.controller;

import com.github.pagehelper.PageInfo;
import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.DepartmentDao;
import com.yc.ams.db.pojo.Department;
import com.yc.ams.db.pojo.Student;
import com.yc.ams.db.pojo.SysUser;
import com.yc.ams.service.UserService;
import com.yc.ams.utils.ResultResponse;
import com.yc.ams.utils.ResultTypeEnum;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
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
@RequestMapping("depart")
public class departController extends BaseController{

    @Resource
    DepartmentDao departmentDao;


    //增加系部
    @RequestMapping("add")
    public ResultResponse addDepart(Department department){

        departmentDao.insert(department);
        System.out.println(department);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("del")
    public ResultResponse del(Department department) {
        if (!StringUtils.isEmpty(department.getId())) {
            if (departmentDao.updateByPrimaryKeySelective(department) == SystemVariable.SUCCESS) {
                return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
            }
        }
        return ResultResponse.Build(ResultTypeEnum.error, SystemVariable.DO_ERROR);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {

        Map<String, Object> so = new HashMap<String, Object>();

        List<Department> ls = departmentDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);

        return so;
    }



}
