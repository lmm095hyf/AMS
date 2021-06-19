package com.yc.ams.utils;

/**
 * Created by 林木木
 * Description : 错误码
 * Version :1.0
 */
public enum ResultTypeEnum {

    success(200),
    fail(400),
    error(500);
    private Integer typeCode;

    ResultTypeEnum(Integer code) {
        this.typeCode = code;
    }

    public Integer getTypeCode() {
        return typeCode;
    }
}
