package rms.demo.exception;

import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import rms.demo.bean.RespBean;
import org.apache.commons.lang3.StringUtils;
/**
 * @author : Meredith
 * @date : 2019-06-03 22:13
 * @description : 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final MessageSource messageSource;

    @Autowired
    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 默认的异常处理
     * @param request
     * @param response
     * @param e
     * @param locale
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespBean defaultErrorHandle(HttpServletRequest request, HttpServletResponse response,
        Exception e, Locale locale) throws IOException {
        RespBean result = RespBean.builder().build();
        int code = 500;
        String errorMessage = null;

        //通过错误码获取定义的错误信息
        if (e instanceof BaseException) {
            code = ((BaseException) e).getCode();
            errorMessage = ((BaseException) e).getErrorMessage();
        } else if (e instanceof MissingServletRequestParameterException) {
            code = BaseException.ERROR_CODE_ILLEGAL_ARGUMENTS;
        } else {
            LOGGER.error("Unknown Exception, URI = " + request.getRequestURI(), e);
        }

        // 如果异常中包含了错误信息，则不会通过错误码获取定义的错误信息
        if (StringUtils.isBlank(errorMessage)) {
            String prefix = ((Throwable) e).getClass().getSimpleName();
            errorMessage = getMessage(prefix + "." + code, locale);
            if (errorMessage == null) {
                errorMessage = getMessage(Integer.toString(code), locale);
            }
        }
        result.setStatus(code);
        result.setMsg(errorMessage);
        return result;
    }

    /**
     * 获取错误信息
     * @param key
     * @param locale
     * @return
     */
    private String getMessage(String key, Locale locale) {
        String errorMessage = null;
        try {
            errorMessage = messageSource.getMessage(key, null, locale);
        } catch (NoSuchMessageException exception) {
            LOGGER.debug("ErrorMessage|NotFound|{}", key);
        }
        return errorMessage;
    }
}
