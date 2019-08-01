package rms.demo.exception;

/**
 * @author : Meredith
 * @date : 2019-06-03 22:09
 * @description : 异常处理基类
 */
public class BaseException extends Exception {

    public static final int ERROR_CODE_ILLEGAL_ARGUMENTS = 600;
    private static final long serialVersionUID = -3392027101671055457L;
    // 错误码
    private int code;
    //错误信息
    private String errorMessage;

    public BaseException(int code) {
        super("error code" + code);
        this.code = code;
    }

    public BaseException(int code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public BaseException(int code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
