package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Department;
import com.yc.ams.db.pojo.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorDao {
    int deleteByPrimaryKey(Integer mid);

    int insert(Major record);

    int insertSelective(Major record);

    List<Major> selectAll();

    Major selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
}