package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysMenuDao {
    int insert(SysMenu record);

    int insertSelective(SysMenu record);
}