package com.loonxi.channel.LinkedIn.exception;

/**
 * Created by xyy on 2017/1/17.
 * 封装接口的错误信息
 */
public class LinkedinError {
    /**
     * 请求ID
     */
    private String requestId;

    /**
     * 错误号
     */
    private int errorCode;

    /**
     * 消息
     */
    private String message;

    /**
     * http 状态码
     */
    private int status;

    /**
     * 请求时间
     */
    private long timestamp;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
