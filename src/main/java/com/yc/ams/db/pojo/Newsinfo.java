package com.yc.ams.db.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * newsinfo
 * @author 
 */
@Data
public class Newsinfo implements Serializable {
    private Integer newid;

    private String newtitle;

    private String newcontent;

    /**
     * 作者
     */
    private String newauthor;

    private Date newdate;

    private String newpictures;

    private static final long serialVersionUID = 1L;
}