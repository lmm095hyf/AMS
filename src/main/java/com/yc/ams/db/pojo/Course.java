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

    /**
     * 课程类型（选修或者必修）（0-1）
     */
    private String citype;

    /**
     * 学分
     */
    private Integer cexam;

    /**
     * 课时
     */
    private Integer cdatenum;

    /**
     * 选课人数
     */
    private Integer cnumber;

    /**
     * 最大选课人数
     */
    private Integer cmaxnumber;

    private static final long serialVersionUID = 1L;
}