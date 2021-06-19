package com.yc.ams.db.dao;

import com.yc.ams.db.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface SysUserDao {
    int deleteByPrimaryKey(Integer sysid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer sysid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectUserPasswordByName(String loginNumber);
}