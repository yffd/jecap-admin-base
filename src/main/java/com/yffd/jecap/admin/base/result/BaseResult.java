package com.yffd.jecap.admin.base.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
public abstract class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -1681710235091565491L;
    /** 响应是否成功  */
    private boolean success;
    /** 响应状态编号  */
    private String code;
    /** 响应描述信息 */
    private String msg;
    /** 响应数据 */
    private T data;

    public BaseResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap(3);
        map.put("success", this.success);
        map.put("code", this.code);
        map.put("msg", this.msg);
        map.put("data", this.data);
        return map;
    }

}
