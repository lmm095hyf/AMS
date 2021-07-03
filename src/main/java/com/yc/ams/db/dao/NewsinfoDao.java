package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Newsinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsinfoDao {
    int deleteByPrimaryKey(Integer newid);

    int insert(Newsinfo record);

    int insertSelective(Newsinfo record);

    List<Newsinfo> selectAll();

    Newsinfo selectByPrimaryKey(Integer newid);

    int updateByPrimaryKeySelective(Newsinfo record);

    int updateByPrimaryKey(Newsinfo record);
}