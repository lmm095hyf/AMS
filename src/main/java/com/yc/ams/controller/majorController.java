package com.yc.ams.controller;

import com.yc.ams.config.SystemVariable;
import com.yc.ams.db.dao.MajorDao;
import com.yc.ams.db.pojo.Major;
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
@RequestMapping("major")
public class majorController {

    @Resource
    MajorDao majorDao;

    //增加系部
    @RequestMapping("add")
    public ResultResponse addMajor(Major major){
        majorDao.insert(major);
        System.out.println(major);
        return ResultResponse.Build(ResultTypeEnum.success, SystemVariable.DO_SUCCESS);
    }

    @RequestMapping("/show")
    public Map<String, Object> showtable() {
        Map<String, Object> so = new HashMap<String, Object>();
        List<Major> ls = majorDao.selectAll();
        so.put("code", SystemVariable.URL_SUCCESS);
        so.put("msg", "");
        so.put("count", ls.size());
        so.put("data", ls);
        return so;
    }
}
