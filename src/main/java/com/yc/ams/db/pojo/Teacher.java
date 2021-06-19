package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * teacher
 * @author 
 */
@Data
public class Teacher implements Serializable {
    private Integer tid;

    private String tname;

    private String tprofession;

    private String tjob;

    private String tstarttime;

    private static final long serialVersionUID = 1L;
}