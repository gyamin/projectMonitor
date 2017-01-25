package com.gyamin.pjmonitor.web.controller.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.web.session.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class SampleController {


    /**
     * セッション開始サンプル
     * @return
     */
    @RequestMapping(value = "/start_session", method = GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object startSession() throws ApplicationException {
        (new SessionManager()).startSession();
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    /**
     * セッション保存サンプル
     * @return
     */
    @RequestMapping(value = "/store_session", method=POST, produces="application/json;charset=utf-8")
    @ResponseBody
    public Object storeSession(@RequestParam("param1") String param1 ) throws ApplicationException, JsonProcessingException {
        Map<String, String> sessionData = new HashMap<String, String>();
        sessionData.put("param1", param1);

        // JSON文字列へ変換
        ObjectMapper mapper = new ObjectMapper();
        String jsonSessionInfo = mapper.writeValueAsString(sessionData);

        (new SessionManager()).storeSessionData(jsonSessionInfo);
        return new ResponseEntity<String>("", HttpStatus.OK);
    }

    /**
     * セッション取得サンプル
     * @return
     */
    @RequestMapping(value = "/get_session", method = GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object getSession() throws ApplicationException {
        String sessionData = (new SessionManager()).getSessionData();
        return new ResponseEntity<String>(sessionData.toString(), HttpStatus.OK);
    }

    /**
     * セッション作成サンプル
     * @return
     */
    @RequestMapping(value = "/test_make_session2", method = GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object makeSession2(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ApplicationException {
        String text;
        String sessionId = "";

        Cookie cookies[] = httpServletRequest.getCookies();
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                if(cookies[i].getName().equals("session_id")){
                    sessionId = cookies[i].getValue();
                }
            }
        }

        if(sessionId.length() == 0) {
            text = "session_idがcookieに存在しないので作成します。";
            sessionId = UUID.randomUUID().toString();
        }else{
            text = "session_idがcookieに存在しました。" + sessionId;
        }

        httpServletResponse.addCookie(new Cookie("session_id", sessionId));
        return new ResponseEntity<String>(text, HttpStatus.OK);
    }

    /**
     * セッションクリアサンプル
     * @return
     */
    @RequestMapping(value = "/test_remove_session2", method = DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object removeSession2(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String text;
        String sessionId = "";

        Cookie cookies[] = httpServletRequest.getCookies();
        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                if(cookies[i].getName().equals("session_id")){
                    sessionId = cookies[i].getValue();
                }
            }
        }

        if(sessionId.length() == 0) {
            text = "session_idがcookieに存在しないので何もしません。";
        }else{
            text = "session_id" +  sessionId + "を削除します。";
        }

        if(cookies != null){
            for(int i = 0; i < cookies.length; i++){
                if(cookies[i].getName().equals("session_id")){
                    cookies[i].setMaxAge(0);
                    httpServletResponse.addCookie(cookies[i]);
                }
            }
        }

        return new ResponseEntity<String>(text, HttpStatus.OK);
    }

}
