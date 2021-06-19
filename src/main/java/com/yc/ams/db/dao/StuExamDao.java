package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.StuExam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuExamDao {
    int deleteByPrimaryKey(Integer examid);

    int insert(StuExam record);

    int insertSelective(StuExam record);

    StuExam selectByPrimaryKey(Integer examid);

    int updateByPrimaryKeySelective(StuExam record);

    int updateByPrimaryKey(StuExam record);
}