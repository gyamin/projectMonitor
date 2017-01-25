package com.gyamin.pjmonitor.web.bean;


import com.gyamin.pjmonitor.entity.Users;

public class SessionInfoBean {

    private Users loginUser;

    public Users getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Users loginUser) {
        this.loginUser = loginUser;
    }

}
