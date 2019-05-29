package rms.demo.bean;

import lombok.Builder;

/**
 * @author : Meredith
 * @date : 2019-05-23 21:44
 * @description : 返回json
 */
@Builder
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;
    private String token;

    //
    // public Integer getStatus() {
    //
    //     return status;
    // }
    //
    // public RespBean setStatus(Integer status) {
    //     this.status = status;
    //     return this;
    // }
    //
    // public String getMsg() {
    //     return msg;
    // }
    //
    // public RespBean setMsg(String msg) {
    //     this.msg = msg;
    //     return this;
    // }
    //
    // public Object getObj() {
    //     return obj;
    // }
    //
    // public RespBean setObj(Object obj) {
    //     this.obj = obj;
    //     return this;
    // }
}
