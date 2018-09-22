    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Date;

/**
 *
 * @author ElViru
 */
public class SystemUser {
    
    private int userId;
    private String user;
    private String pass;
    private boolean auth;
    private GenericClass userType;
    private GenericClass userEstado;
    private Date fechaReg;

    
    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public int getUserId() {
        return userId;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public GenericClass getUserType() {
        return userType;
    }

    public void setUserType(GenericClass userType) {
        this.userType = userType;
    }

    public GenericClass getUserEstado() {
        return userEstado;
    }

    public void setUserEstado(GenericClass userEstado) {
        this.userEstado = userEstado;
    }

    
    
    /****    constructores    ****/
    
    public SystemUser() {
    }

    public SystemUser(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public SystemUser(String user, String pass, boolean auth) {
        this.user = user;
        this.pass = pass;
        this.auth = auth;
    }

    public SystemUser(int userId, String user) {
        this.userId = userId;
        this.user = user;
    }

    public SystemUser(int userId, String user, String pass, boolean auth) {
        this.userId = userId;
        this.user = user;
        this.pass = pass;
        this.auth = auth;
    }

    public SystemUser(int userId, String user, String pass, boolean auth, GenericClass userType) {
        this.userId = userId;
        this.user = user;
        this.pass = pass;
        this.auth = auth;
        this.userType = userType;
    }

    public SystemUser(String user, String pass, boolean auth, GenericClass userType, GenericClass userEstado) {
        this.user = user;
        this.pass = pass;
        this.auth = auth;
        this.userType = userType;
        this.userEstado = userEstado;
    }
    
    public SystemUser(int userId, String user, boolean auth, GenericClass userType) {
        this.userId = userId;
        this.user = user;
        this.auth = auth;
        this.userType = userType;
    }
    
}
