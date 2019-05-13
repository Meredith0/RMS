package rms.demo.config.SpringBoot_Security;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : Meredith
 * @date : 2019-05-09 23:43
 * @description : 自定义密码加密算法   这里取消加密
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
