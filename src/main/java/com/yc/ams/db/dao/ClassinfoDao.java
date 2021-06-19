package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Classinfo;
import com.yc.ams.db.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassinfoDao {
    int deleteByPrimaryKey(Integer cid);

    int insert(Classinfo record);

    int insertSelective(Classinfo record);

    List<Classinfo> selectAll();

    Classinfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Classinfo record);

    int updateByPrimaryKey(Classinfo record);
}