package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * major
 * @author 
 */
@Data
public class Major implements Serializable {
    private Integer mid;

    private String mname;

    private Integer mnumber;

    private String dename;

    private Integer myear;

    private static final long serialVersionUID = 1L;
}