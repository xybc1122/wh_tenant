package com.wh.store;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BindingResultStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/28 9:54
 **/
public class BindingResultStore {

    /**
     * 遍历打印校验错误参数
     *
     * @param bindingResult
     * @return
     */
    public static String bindingResult(BindingResult bindingResult) {
        Map<String, String> bindingResultMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            // 得到全部不合法的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            // 遍历不合法字段
            fieldErrors.forEach(
                    fieldError -> {
                        bindingResultMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    }
            );
            return bindingResultMap.toString();
        }
        return null;
    }
}
