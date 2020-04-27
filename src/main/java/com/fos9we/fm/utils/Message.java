package com.fos9we.fm.utils;

/**
 *@ClassName: Message
 *@Description: 统一接口返回数据模型
 * @author Administrator
 *@date 2020年4月25日 上午10:57:12 
 */
public class Message {
    private Integer status; //状态码 200 500
    private String message; //信息
    private Object data;    //操作结果，查询结构
    private Long timestamp; //时间戳

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}

