package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.Major;
import com.yc.ams.db.pojo.Tevaluta;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TevalutaDao {
    int deleteByPrimaryKey(Integer teid);

    int insert(Tevaluta record);

    int insertSelective(Tevaluta record);

    List<Tevaluta> selectAll();

    Tevaluta selectByPrimaryKey(Integer teid);

    int updateByPrimaryKeySelective(Tevaluta record);

    int updateByPrimaryKey(Tevaluta record);
}