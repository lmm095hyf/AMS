package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Newsinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsinfoDao {
    int deleteByPrimaryKey(Integer newid);

    int insert(Newsinfo record);

    int insertSelective(Newsinfo record);

    Newsinfo selectByPrimaryKey(Integer newid);

    int updateByPrimaryKeySelective(Newsinfo record);

    int updateByPrimaryKey(Newsinfo record);
}