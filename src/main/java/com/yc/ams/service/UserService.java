package com.yc.ams.service;

import com.yc.ams.db.pojo.Department;
import com.yc.ams.db.pojo.Student;
import com.yc.ams.db.pojo.SysUser;

import java.util.List;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-02 19:45
 */

public interface UserService {
    SysUser selectUserPasswordByName(String loginNumber);

//    Integer updateUserPassword(SysUser sysUser);

//    List<Student> selectStudentInfo(ReqStudent reqStudent);
//
//    int updateByPrimaryKeyUserSelective(SysUser record);
//
//    StudentInfo selectStudentInfoById(Integer id);
//
//    StudentInfoUpdate selectStudentInfoUpdateById(Integer id);
//
//    List<SysUser> selectByExample(SysUserExample example);
//
//    WelcomeNum selectWelcomeNum();

    List<Department> findAllPage(Integer pageNum,Integer pageSize);
    int insertSelective(SysUser record);
}
