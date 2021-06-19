package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * department
 * @author 
 */
@Data
public class Department implements Serializable {
    private Integer deid;

    private String dename;

    private String deintro;

    private Integer denumber;

    private static final long serialVersionUID = 1L;

    //返回id
    public Object getId() {
        return deid;
    }


}