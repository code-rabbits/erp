package com.star.sys.utils;

/**
 * layui 数据表格类
 *
 * layui的数据表格组件需要返回4个属性值，
 * 分别是code,msg,count,data。故封装DataGridViewResult类
 */
public class DataGridViewResult {
    private Integer code=0;//执行状态码
    private String msg="";//提示信息
    private Long count=0L;//数量
    private Object data;//数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DataGridViewResult(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }
    public DataGridViewResult(Object data) {
        super();
        this.data = data;
    }

    public DataGridViewResult() {
    }
}