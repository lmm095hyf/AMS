package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}