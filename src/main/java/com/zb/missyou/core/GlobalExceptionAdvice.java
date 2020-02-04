package com.zb.missyou.core;

import com.zb.missyou.core.configuration.ExceptionCodeConfiguration;
import com.zb.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.awt.*;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        UnifyResponse message = new UnifyResponse(999, "服务器异常", method + " " + requestUrl);
        return message;
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity handleHttpException(HttpServletRequest req, HttpException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        UnifyResponse message = new UnifyResponse(e.getCode(), exceptionCodeConfiguration.getMessages(e.getCode()), method + " " + requestUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(message, headers, httpStatus);
        return r;
    }

    // url参数出现问题时
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public UnifyResponse handleConstraintException(HttpServletRequest req, ConstraintViolationException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        String msg = e.getMessage();
        UnifyResponse message = new UnifyResponse(10001, msg, method + " " + requestUrl);
        return message;
        // 定制化用这个
 //       for (ConstraintViolation error: e.getConstraintViolations()) {
//            ConstraintViolation a = error;
//        }
    }
    // 校验出现问题时
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidation(HttpServletRequest req, MethodArgumentNotValidException e) {
        String requestUrl = req.getRequestURI();
        String method = req.getMethod();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String messages = this.formatAllErrorMessages(errors);
        UnifyResponse message = new UnifyResponse(10001, messages, method + " " + requestUrl);
        return message;
    }

    // 把数组拼接成字符串
    private String formatAllErrorMessages(List<ObjectError> errors) {
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error ->
                errorMsg.append(error.getDefaultMessage()).append(";"));
        return errorMsg.toString();
    }
}
