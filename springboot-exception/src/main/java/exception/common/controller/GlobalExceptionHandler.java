package exception.common.controller;

import exception.common.exceptions.CustomException;
import exception.common.exceptions.ErrorResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sunlele
 * Date 2019/2/24 18:35
 * Description全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     *定义要捕获的异常 ---即捕获自定义异常
     * @param request
     * @param ex
     * @param response
     * @return
     */
    public ErrorResponseEntity customExceptionHandler(HttpServletRequest request,
                                                      final Exception ex,
                                                      HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        CustomException exception = (CustomException) ex;
        return new ErrorResponseEntity(exception.getCode(),exception.getMessage());
    }

    /**
     * 捕获RuntimeException
     * 其次，可以通过if(x instanceOf xException来处理更多的异常)；或者可以使用多个handler来处理异常
     * @param request
     * @param ex
     * @param response
     * @return
     */
    public ErrorResponseEntity runtimeExceptionHandler(HttpServletRequest request,
                                                       final Exception ex,
                                                       HttpServletResponse response){
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) ex;
        return  new ErrorResponseEntity(400,ex.getMessage());
    }

    /**
     * 通用的接口映射处理方
     * @param ex
     * @param body 响应主体
     * @param headers  响应的标头
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
       if(ex instanceof MethodArgumentNotValidException){
           MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
           return new ResponseEntity<>(new ErrorResponseEntity(status.value(),
                   exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()),status);
       }
       if(ex instanceof MethodArgumentNotValidException){
           MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
           log.error("参数转换失败，方法：" +
                   exception.getParameter().getMethod().getName() + "，参数：" +
                   log.getName() + ",信息：" + exception.getLocalizedMessage());
           return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
       }
        return new ResponseEntity<>(new ErrorResponseEntity(status.value(), "参数转换失败"), status);
    }
}
