package com.yc.ams.controller;

import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.MajorDao;
import com.yc.ams.db.dao.TevalutaDao;
import com.yc.ams.db.pojo.Major;
import com.yc.ams.db.pojo.Tevaluta;
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
@RequestMapping("evlist")
public class evlistController {


    @Resource
    TevalutaDao tevalutaDao;
    //增加教评问题
    @RequestMapping("add")
    public ResultResponse addMajor(Tevaluta tevaluta){
        tevalutaDao.insert(tevaluta);
        System.out.println(tevaluta);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {
        Map<String, Object> so = new HashMap<String, Object>();
        List<Tevaluta> ls = tevalutaDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);
        return so;
    }
}
