package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Student;
import com.yc.ams.db.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {
    int deleteByPrimaryKey(Integer sid);

    int insert(Student record);

    int insertSelective(Student record);


    List<Student> selectAll();

    Student selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}