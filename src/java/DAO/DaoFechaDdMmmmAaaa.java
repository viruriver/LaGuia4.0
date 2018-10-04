/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Dao.getResultSetSelectAll;
import Domain.FechaDdMmmmAaaa;
import Domain.PaisProvinciaCiudad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElViru
 */
public class DaoFechaDdMmmmAaaa {
    
    private static final String TABLA = "DimFecha";
    private static final String COLUMNA_ID = "id";
    private static final String COLUMNA_AÑOAAAA = "añoId";
    private static final String COLUMNA_MESMMMM = "mesMMMM";
    private static final String COLUMNA_DIADD = "diaDD";
    
       
    private static final String RECUPERAR_FECHADDMMMMAAAA = String.format("select id ,añoId ,mesMMMM ,diaDD from %1s where userName = ?", TABLA);
    
    
    
    
    public List<FechaDdMmmmAaaa> getFechaDdMmmmAaaaALL() {
        List<FechaDdMmmmAaaa> list = new ArrayList();
        try {
            ResultSet result = getResultSetSelectAll(TABLA);
            while (result != null && result.next()) {
                FechaDdMmmmAaaa fechaDdMmmmAaaa = new FechaDdMmmmAaaa();
                
                int resId = result.getInt(COLUMNA_ID);
                String resAño = result.getString(COLUMNA_AÑOAAAA);
                String resMes = result.getString(COLUMNA_MESMMMM);
                String resDia = result.getString(COLUMNA_DIADD);
                
                
                fechaDdMmmmAaaa.setId(resId);
                fechaDdMmmmAaaa.setAño(resAño);
                fechaDdMmmmAaaa.setMes(resMes);
                fechaDdMmmmAaaa.setDia(resDia);
                
                list.add(fechaDdMmmmAaaa);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return list;
    }
    
}
