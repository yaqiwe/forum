package com.example.forum;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 11:19
 * @description：提取数据校验错误的错误信息
 */
public class ConExceptionUtil {
    public static String getValidationMessage(Exception e){
        if(e instanceof ConstraintViolationException){
            ConstraintViolationException cve= (ConstraintViolationException) e;
            List<String> defaultMsg = cve.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            return defaultMsg.toString();
        }
        return null;
    }
}
