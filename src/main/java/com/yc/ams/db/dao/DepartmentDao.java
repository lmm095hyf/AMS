package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {
    int deleteByPrimaryKey(Integer deid);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer deid);

    List<Department> selectAll();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);


    Department selectStudentInfoById(Integer deid);
}