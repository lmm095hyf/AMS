package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_menu
 * @author 
 */
@Data
public class SysMenu implements Serializable {
    private Integer sysrole;

    private String sysrolename;

    private static final long serialVersionUID = 1L;
}