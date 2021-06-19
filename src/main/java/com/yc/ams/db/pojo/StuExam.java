package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * stu_exam
 * @author 
 */
@Data
public class StuExam implements Serializable {
    private Integer examid;

    private Integer cid;

    private Integer sid;

    private String grade;

    private static final long serialVersionUID = 1L;
}