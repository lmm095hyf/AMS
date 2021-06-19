package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer sid;

    private String sname;

    private String smajor;

    private String sdepart;

    private static final long serialVersionUID = 1L;
}