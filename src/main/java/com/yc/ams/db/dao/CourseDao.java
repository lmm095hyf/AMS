package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Course;
import com.yc.ams.db.pojo.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectAll();

    Course selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}