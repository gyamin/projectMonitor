package com.gyamin.pjmonitor.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gyamin.pjmonitor.web.bean.ErrorResponse;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.pjmonitor.web.exception.ValidateException;
import com.gyamin.pjmonitor.web.request.ProjectDataRequest;
import com.gyamin.pjmonitor.service.ProjectDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ProjectDataController {

    /**
     * ログイン画面表示
     * @return
     */
//    @RequestMapping(value = "/login", method = GET)
//    public String loginIndex() {
//        return "login/index";
//    }
//    *******************************************
//    画面表示などの静的コンテンツは/dist/html/login/index.html のように
//    /distディレクトリからリソースとして配信。サーバサイドはAPIのみを実装するSPA構成にする
//    *******************************************

    /**
     * 処理
     * @param request
     * @param bindingResult
     * @return
     * @throws ValidateException
     */
    @RequestMapping(value = "/project_data", method = GET, consumes= MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public Object getProjectData(@RequestBody @Valid ProjectDataRequest request, BindingResult bindingResult)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
        // リクエストバリデーション
        if(bindingResult.hasErrors()) {
            ValidateException validateException = new ValidateException("バリデーションエラー");
            validateException.errors = bindingResult.getFieldErrors();
            throw validateException;
        }
        // プロジェクトデータ取得処理を行う
        ProjectDataService service = new ProjectDataService();
        String sessionInfo = service.getProjectData(request.getProjectId());

        return new ResponseEntity<String>(sessionInfo, HttpStatus.OK);
    }

    /**
     * アプリケーションエラー時レスポンス処理
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ApplicationException.class })
    @ResponseBody
    public ErrorResponse applicatinError(ApplicationException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        return errorResponse;
    }

    /**
     * バリデーションエラー時レスポンス処理
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ValidateException.class })
    @ResponseBody
    public ErrorResponse validateError(ValidateException exception) {
        ErrorResponse errorResponse = new ErrorResponse();

        List<Map<String,Object>> errorList = new ArrayList();
        for(ObjectError error : exception.errors ) {
            Map<String, Object> info = new HashMap<String, Object>();
            info.put("field", ((FieldError) error).getField());
            info.put("message", ((FieldError) error).getDefaultMessage());
            errorList.add(info);
        }
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setFieldErrors(errorList);
        return errorResponse;
    }
}
