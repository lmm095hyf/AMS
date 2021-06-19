package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Department;
import com.yc.ams.db.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    int deleteByPrimaryKey(Integer tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tid);

    List<Teacher> selectAll();


    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}