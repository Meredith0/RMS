package rms.demo.common;

import java.util.Objects;
import lombok.Builder;
import lombok.Data;

/**
 * @author : Meredith
 * @date : 2019-05-23 21:44
 * @description : 返回json
 */
@Data
@Builder
public class RespBean {

    private int status;
    private String msg;
    private Object data;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RespBean)) {
            return false;
        }
        RespBean result = (RespBean) o;
        return status == result.status
                   && Objects.equals(msg, result.msg)
                   && Objects.equals(data, result.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, msg, data);
    }
}
