package com.yc.ams.service.impl;

import com.github.pagehelper.PageHelper;
import com.yc.ams.db.dao.DepartmentDao;
import com.yc.ams.db.dao.SysUserDao;
import com.yc.ams.db.pojo.Department;
import com.yc.ams.db.pojo.SysUser;
import com.yc.ams.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-02 19:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    private DepartmentDao departmentDao;
    //private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserPasswordByName(String loginNumber) {
        System.out.println("loginNumber:"+loginNumber);
        return sysUserDao.selectUserPasswordByName(loginNumber);
    }

    @Override
    public List<Department> findAllPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return departmentDao.selectAll();
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserDao.insertSelective(record);
    }
}
