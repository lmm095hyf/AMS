package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * course
 * @author 
 */
@Data
public class Course implements Serializable {
    private Integer cid;

    private String coname;

    private static final long serialVersionUID = 1L;
}