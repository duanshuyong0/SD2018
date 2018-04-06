package com.loonxi.mail.entity;

/**
 * @author <a href="mailto:xieda@loonxi.com">谢达</a>
 * @version 1.0 5/1/17
 * @since 1.0
 */

public class UserAuthentication {
    private String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
