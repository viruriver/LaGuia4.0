/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Dao;
import Domain.GenericClass;
import Domain.SQLMappingTable;
import Domain.SystemUser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElViru
 */
public class SystemUserDao extends Dao  {
    
    
    private static final String TABLA = "UserSystemLogin";
    private static final String COLUMNA_USER_ID = "id";
    private static final String COLUMNA_USER_NAME = "userName";
    private static final String COLUMNA_USER_PASS = "userPassword";
    private static final String COLUMNA_USER_PASS_AUTH = "userPassAuth";
    private static final String COLUMNA_USER_TYPE = "userTipo";
    private static final String COLUMNA_USER_ESTADO = "userEstado";
        
    private static final String RECUPERAR_USER = String.format("select * from %1s where userName = ?", TABLA);
    
    private static final String USER_PASS_AUTH = String.format("select * from %1s where userName = ? and userPassword = ?", TABLA);
    
    private static final String GUARDAR_USER = String.format("insert into %1s(%1s, %2s, %3s, %4s, %5s) values(?,?,?,?,?)",
            TABLA, COLUMNA_USER_NAME, COLUMNA_USER_PASS, COLUMNA_USER_PASS_AUTH, COLUMNA_USER_TYPE, COLUMNA_USER_ESTADO);
    
    private static final String CAMBIAR_PASS = String.format("update %1s set %2s = ? where %3s = ?",
            TABLA, COLUMNA_USER_PASS, COLUMNA_USER_NAME);

    
    
    
    public List<SystemUser> getSystemUserALL() {
        List<SystemUser> usersList = new ArrayList();
        try {
            ResultSet result = getResultSetSelectAll(TABLA);
            while (result != null && result.next()) {
                SystemUser systemUser = new SystemUser();
                
                int resId = result.getInt(COLUMNA_USER_ID);
                String resUserName = result.getString(COLUMNA_USER_NAME);
                boolean resUserPassAuth = result.getBoolean(COLUMNA_USER_PASS_AUTH);
                int resUserType = result.getInt(COLUMNA_USER_TYPE);
                int resUserEstado = result.getInt(COLUMNA_USER_ESTADO);
                
                GenericClass genUserType = Dao.getSelectOneId(SQLMappingTable.SQL_USER_SYSTEM_TYPE, resUserType);
                
                GenericClass genUserEstado = Dao.getSelectOneId(SQLMappingTable.SQL_DIM_ESTADO, resUserEstado);
                
                systemUser.setUserId(resId);
                systemUser.setUser(resUserName);
                systemUser.setAuth(resUserPassAuth);
                systemUser.setUserType(genUserType);
                systemUser.setUserEstado(genUserEstado);
                
                usersList.add(systemUser);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return usersList;
    }
    
    
    public SystemUser getSystemUser(String userName) {
        SystemUser systemUser = new SystemUser();
        try {
            PreparedStatement preparedStatement = getPreparedStatement(RECUPERAR_USER);
            preparedStatement.setString(1, userName);
            ResultSet result = preparedStatement.executeQuery();
            if (result != null && result.next()) {
                int resId = result.getInt(COLUMNA_USER_ID);
                String resUserName = result.getString(COLUMNA_USER_NAME);
                boolean resUserPassAuth = result.getBoolean(COLUMNA_USER_PASS_AUTH);
                int resUserType = result.getInt(COLUMNA_USER_TYPE);
                
                GenericClass genUserType = Dao.getSelectOneId(SQLMappingTable.SQL_USER_SYSTEM_TYPE, resUserType);
                
                systemUser.setUserId(resId);
                systemUser.setUser(resUserName);
                systemUser.setAuth(resUserPassAuth);
                systemUser.setUserType(genUserType);
                
            }
        } catch (SQLException e) {
            System.out.println("Problema el tratar de recuperar el Cliente");
            e.printStackTrace();
        }
        return systemUser;
    }
    
        
    public boolean getSystemUserAUTH(String userName, String userPass) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(USER_PASS_AUTH);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPass);
            ResultSet result = preparedStatement.executeQuery();
            if (result != null && result.next()) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Problema el tratar de recuperar el Cliente");
            e.printStackTrace();
            return false;
        }
    }
    
    
    public int systemUserSave(SystemUser user) {
        PreparedStatement preparedStatement = getPreparedStatement(GUARDAR_USER);
        try {
            preparedStatement.setString(1, user.getUser());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setBoolean(3, user.isAuth());
            preparedStatement.setInt(4, user.getUserType().getId());
            preparedStatement.setInt(5, user.getUserEstado().getId());
            preparedStatement.executeUpdate();
            return getIdIngresado(preparedStatement);
        } catch (SQLException e) {
            System.out.println("Error al guardar el usuario");
            e.printStackTrace();
        }
        return OPERACION_FALLIDA;
    }
    
    
    public void systemUserPassReset(String userName){
    
    };
    
    
    public void systemUserPassUpdate(String userName, String newUserPass){
        
        try {
            PreparedStatement preparedStatement = getPreparedStatement(CAMBIAR_PASS);
            preparedStatement.setString(1, newUserPass);
            preparedStatement.setString(2, userName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("no se pudo actualizar la contraseña");
            e.printStackTrace();
        }
        
    };
    
    
}
