package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.StuCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuCourseDao {


    List<StuCourse> selSc();


}
