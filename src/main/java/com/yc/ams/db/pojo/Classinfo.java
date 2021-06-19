package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * classinfo
 * @author 
 */
@Data
public class Classinfo implements Serializable {
    private Integer cid;

    private String cname;

    private Integer csize;

    private String chead;

    private String profession;

    private String deid;

    private static final long serialVersionUID = 1L;
}