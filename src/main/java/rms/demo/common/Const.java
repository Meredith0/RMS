package rms.demo.common;
/**
 * @author : Meredith
 * @date : 2019-07-26 16:48
 * @description : 常量
 */
public class Const {

    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "Q43BNV82V7";      // JWT密码

    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
