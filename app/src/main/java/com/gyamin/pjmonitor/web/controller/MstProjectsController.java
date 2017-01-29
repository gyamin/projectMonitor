package com.gyamin.pjmonitor.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.service.MstProjectsService;
import com.gyamin.pjmonitor.web.bean.ErrorResponseBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.pjmonitor.web.exception.ValidateException;
import com.gyamin.pjmonitor.web.request.ProjectDataRequest;
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

@RestController
public class MstProjectsController {

    /**
     * 処理
     * @return
     * @throws ValidateException
     */
    @RequestMapping(value = "/api/mst_projects", method = GET, produces = "application/json")
    public Object index(@RequestParam(required = false) String projectNo)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {

        // プロジェクトデータ取得処理を行う
        MstProjectsService service = new MstProjectsService();
        List<MstProjects> mstProjectsList = service.getMstProjectsData();

        // JSON文字列へ変換
        ObjectMapper mapper = new ObjectMapper();
        String jsonSessionInfo = mapper.writeValueAsString(mstProjectsList);

        return new ResponseEntity<String>(jsonSessionInfo, HttpStatus.OK);
    }

    /**
     * アプリケーションエラー時レスポンス処理
     * @param exception
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ApplicationException.class })
    @ResponseBody
    public ErrorResponseBean applicationError(ApplicationException exception) {
        ErrorResponseBean errorResponse = new ErrorResponseBean();
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
    public ErrorResponseBean validateError(ValidateException exception) {
        ErrorResponseBean errorResponse = new ErrorResponseBean();

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
