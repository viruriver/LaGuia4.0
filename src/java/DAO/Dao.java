/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.DBConnection;
import Domain.GenericClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElViru
 */
public class Dao {
    
    private static final Connection connection = DBConnection.getConexion();
    
    private static final String COLUMNA_ID = "id";
    private static final String COLUMNA_DESC = "descripcion";
    private static final String COLUMNA_ID_REF = "idRef";
    
    protected static final int OPERACION_EXITOSA = 1;
    protected static final int OPERACION_FALLIDA = -1;
    
    
    
    public static int getOPERACION_FALLIDA(){
        return OPERACION_FALLIDA;
    }
    
    
    
    protected int getIdIngresado(PreparedStatement preparedStatement) throws SQLException{
        ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                long operacion = rs.getLong(1);
                return (int) rs.getLong(1);
            }
        return OPERACION_FALLIDA;
    }
    
    
    protected int getUltimoCodigo(String Tabla) throws SQLException{
        Statement st = connection.createStatement();
        String sql = "select max(codigo) from " + Tabla;
        ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return (int) rs.getInt(1);
            }
    return OPERACION_FALLIDA;
    } 
    
    
    protected PreparedStatement getPreparedStatement(String query){
        PreparedStatement pStatement = null;
        try{
            pStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        }catch(Exception e){
            System.out.println("Problema al recuperar el PreparedStatement");
            e.printStackTrace();
        }
        return pStatement;
    }
    
    
    protected static ResultSet getResultSetSelectAll(String tabla){
        ResultSet result = null;
        try{
            result = getResultSet(connection.prepareStatement("select * from " + tabla));
        }catch(SQLException e){
            System.out.println("Problema al recuperar el ResultSet de select * from");
            e.printStackTrace();
        }
        return result;
    }
    
    protected static ResultSet getResultSetSelectAllWhereCond(String tabla, int cond){
        ResultSet result = null;
        try{
            result = getResultSet(connection.prepareStatement("select * from " + tabla + " where " + COLUMNA_ID_REF + " = " + cond));
        }catch(SQLException e){
            System.out.println("Problema al recuperar el ResultSet de select * from");
            e.printStackTrace();
        }
        return result;
    }
        
    protected static ResultSet getResultSetSelectOneId(String tabla, int id){
        ResultSet result = null;
        try{
            result = getResultSet(connection.prepareStatement("select * from " + tabla + " where " + COLUMNA_ID + " = " + id));
            String control = "";
        }catch(SQLException e){
            System.out.println("Problema al recuperar el ResultSet de select * from");
            e.printStackTrace();
        }
        return result;
    }
    
    protected static ResultSet getResultSetSelectOneDesc(String tabla, String desc){
        ResultSet result = null;
        try{
            result = getResultSet(connection.prepareStatement("select * from " + tabla + " where " + COLUMNA_DESC + " = '" + desc + "' "));
            String control = "";
        }catch(SQLException e){
            System.out.println("Problema al recuperar el ResultSet de select * from");
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static List<GenericClass> getSelectAll(String tabla){
        
        List<GenericClass> genericList = new ArrayList();
        try {
            ResultSet result = getResultSetSelectAll(tabla);
            while (result != null && result.next()) {
                GenericClass generic = new GenericClass(
                        result.getInt(COLUMNA_ID),
                        result.getString(COLUMNA_DESC)
                );
                genericList.add(generic);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return genericList;
    }
    
    public static List<GenericClass> getSelectAllWhereCond(String tabla, int cond){
        
        List<GenericClass> genericList = new ArrayList();
        try {
            ResultSet result = getResultSetSelectAllWhereCond(tabla,cond);
            while (result != null && result.next()) {
                GenericClass generic = new GenericClass(
                        result.getInt(COLUMNA_ID),
                        result.getString(COLUMNA_DESC)
                );
                genericList.add(generic);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return genericList;
    }
        
    public static GenericClass getSelectOneId(String tabla, int id){
        
        GenericClass generic = new GenericClass();
        
        try {
            ResultSet result = getResultSetSelectOneId(tabla, id);
            while (result != null && result.next()) {
                generic.setId(result.getInt(COLUMNA_ID));
                generic.setDesc(result.getString(COLUMNA_DESC));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return generic;
    }
        
    public static GenericClass getSelectOneDesc(String tabla, String desc){
        
        GenericClass generic = new GenericClass();
        
        try {
            ResultSet result = getResultSetSelectOneDesc(tabla, desc);
            while (result != null && result.next()) {
                generic.setId(result.getInt(COLUMNA_ID));
                generic.setDesc(result.getString(COLUMNA_DESC));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return generic;
    }
    
    
    
    
    
    protected static ResultSet getResultSet(PreparedStatement preparedStatement){
        ResultSet result = null;
        try{
            result = preparedStatement.executeQuery();
        }catch(Exception e){
            System.out.println("Problema al recuperar el ResultSet");
            e.printStackTrace();
        }
        return result;
    }
    
    
    
    
}
