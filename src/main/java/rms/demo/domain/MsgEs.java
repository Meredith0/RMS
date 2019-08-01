package rms.demo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: SSM01
 *
 * @author CM
 * Created by Administrator on 2019/7/26 9:25
 */
public class MsgEs {
    /**
    状态码   100-成功    200-失败
     */
    private int code;
    /**
     提示信息
     */
    private String msg;

    /**
    用户要返回给浏览器的数据
    */
    private Map<String, Object> extend = new HashMap<String, Object>();

    public static MsgEs success(){
        MsgEs result = new MsgEs();
        result.setCode(100);
        result.setMsgEs("处理成功！");
        return result;
    }

    public static MsgEs fail(){
        MsgEs result = new MsgEs();
        result.setCode(200);
        result.setMsgEs("处理失败！");
        return result;
    }

    public MsgEs add(String key,Object value){
        this.getExtend().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsgEs() {
        return msg;
    }

    public void setMsgEs(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

}
