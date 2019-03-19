package com.satou.webAvancee.model;

import com.satou.webAvancee.dao.DAOException;
import com.satou.webAvancee.dao.DAOFactory;
import com.satou.webAvancee.dao.UserDao;

public class SessionBean {

    private static final String PSEUDO_BAND = "pseudoh";
    private static final String PWD_BAND    = "pwdh";
    private static final String LOGIN_BOOL  = "login";

    private String              pseudo;
    private String              pwd;
    private boolean             login;
    private UserDao				userDao;

    public SessionBean( String pseudo, String pwd, UserDao userDao ) {
        super();
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.userDao = userDao;

        System.out.println( pseudo );
        System.out.println( pwd );

        if ( check( pseudo, pwd ) ) {
            this.login = true;
        } else {
            this.login = false;
        }
    }

    public boolean check( String p, String l ) {
        return userDao.verifier(p, l);
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin( boolean login ) {
        this.login = login;
    }

}