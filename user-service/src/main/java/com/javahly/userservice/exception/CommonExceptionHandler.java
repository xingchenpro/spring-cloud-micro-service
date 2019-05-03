package com.javahly.userservice.exception;

import com.javahly.userservice.dto.RespDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/5/3
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<RespDTO> handleException(Exception e) {
        RespDTO resp = new RespDTO();
        CommonException taiChiException = (CommonException) e;
        resp.code = taiChiException.getCode();
        resp.error = e.getMessage();

        return new ResponseEntity(resp, HttpStatus.OK);
    }

}
