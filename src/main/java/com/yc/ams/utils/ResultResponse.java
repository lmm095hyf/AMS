package com.yc.ams.utils;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by 林木木
 * Description :错误码
 * Version :1.0
 */
public class ResultResponse implements Serializable {
    //执行结果
    private Object excuteResult;
    //状态类型
    private ResultTypeEnum resultTypeEnum;
    //执行时间
    private Long excuteDurationTime = new Date().getTime();

    private Object message;

    public Object getExcuteResult() {
        return excuteResult;
    }

    public ResultResponse() {
    }

    public static ResultResponse Build(ResultTypeEnum resultTypeEnum) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setResultTypeEnum(resultTypeEnum);
        return resultResponse;
    }

    public static ResultResponse Build(ResultTypeEnum resultTypeEnum, Object message) {
        ResultResponse resultResponse = Build(resultTypeEnum);
        resultResponse.setMessage(message);
        return resultResponse;
    }

    public static ResultResponse Build(Object excuteResult,ResultTypeEnum resultTypeEnum, Object message) {
        ResultResponse resultResponse = Build(resultTypeEnum);
        resultResponse.setMessage(message);
        resultResponse.setExcuteResult(excuteResult);
        return resultResponse;
    }

    public void setExcuteResult(Object excuteResult) {
        this.excuteResult = excuteResult;
    }

    public Integer getResultTypeEnum() {
        return resultTypeEnum.getTypeCode();
    }

    public void setResultTypeEnum(ResultTypeEnum resultTypeEnum) {
        this.resultTypeEnum = resultTypeEnum;
    }

    public Long getExcuteDurationTime() {
        return excuteDurationTime;
    }

    public void setExcuteDurationTime(Long excuteDurationTime) {
        this.excuteDurationTime = excuteDurationTime;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
