package rms.demo.config.SpringBoot_Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : Meredith
 * @date : 2019-05-09 23:43
 * @description : 自定义密码加密算法   暂时取消加密
 */
@Configuration
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return encode(charSequence).equals(s);
    }
}
