package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Integer sysid;

    private String sysname;

    private String syspwd;

    private Integer sysrole;

    public Integer getId() {
        return sysid;
    }

    private static final long serialVersionUID = 1L;

    public String getUserNumber() {
        System.out.println(sysname);//null
        return sysname;
    }

    public String getUserPassword() {
        System.out.println(syspwd);//null
        return syspwd;
    }
}