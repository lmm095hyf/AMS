package com.yc.ams.db.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * tevaluta
 * @author 
 */
@Data
public class Tevaluta implements Serializable {
    private Integer teid;

    /**
     * 内容
     */
    private String tecontent;

    private static final long serialVersionUID = 1L;
}