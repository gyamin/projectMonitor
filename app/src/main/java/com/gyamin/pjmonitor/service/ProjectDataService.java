package com.gyamin.pjmonitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.web.bean.SessionInfoBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.pjmonitor.web.request.ProjectDataRequest;
import com.gyamin.web.session.SessionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class ProjectDataService {
//    public String doLogin(ProjectDataRequest request) throws ApplicationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {
//
//        TransactionManager tm = AppConfig.singleton().getTransactionManager();
//
//
//        UsersDao dao = new UsersDaoImpl();
//
//        Users loginUser = tm.required(() -> {
//            return dao.selectByLoginIdPassword(request.getId(), request.getPassword());
//        });
//
//        if(loginUser == null) {
//            // ユーザが存在しない場合
//            throw new ApplicationException("ログインIDまたはパスワードに誤りがあります。");
//        }
//
//        // セッション開始
//        (new SessionManager()).startSession();
//
//        SessionInfoBean sessionInfoBean = new SessionInfoBean();
//        sessionInfoBean.setLoginUser(loginUser);
//
//        // セッション情報にユーザ情報を格納
//        ObjectMapper mapper = new ObjectMapper();
//        // JavaBeansオブジェクトをJSON文字列へ変換
//        String jsonSessionInfo = mapper.writeValueAsString(sessionInfoBean);
//
//        (new SessionManager()).storeSessionData(jsonSessionInfo);
//        return jsonSessionInfo;
//    }
}
