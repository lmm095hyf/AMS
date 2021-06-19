package com.yc.ams.db.pojo;

import lombok.Data;

/**
 * @program: AMS
 * @description:
 * @author: 作者 :林木木
 * @create: 2021-06-04 20:22
 */
@Data
public class Result {
    /**
     * json返回值
     *   {
     *      "code": 0,
     *      "flag": true,
     *      "message": "string",
     *      "data": [
     *          {
     *          "id": "string",
     *          "labelname": "string",
     *          "state": "string",
     *          "count": 0,
     *          "recommend": "string"
     *          }
     *       ]
     *   }
     * */
    private int code;
    private String message;
    private boolean flag;
    private Object data;
}


