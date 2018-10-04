/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Dao.getResultSetSelectAll;
import Domain.GenericClass;
import Domain.PaisProvinciaCiudad;
import Domain.SQLMappingTable;
import Domain.SystemUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElViru
 */
public class DaoPaisProvinciaCiudad extends Dao{
    
    private static final String TABLA = "PaisProvinciaCiudad";
    private static final String COLUMNA_ID = "id";
    private static final String COLUMNA_PAIS = "Pais";
    private static final String COLUMNA_PROVINCIA = "Provincia";
    private static final String COLUMNA_LOCALIDAD = "Localidad";
    
       
    private static final String RECUPERAR_PaisProvinciaCiudad = String.format("select * from %1s where userName = ?", TABLA);
    
    
    public List<PaisProvinciaCiudad> getPaisProvinciaCiudadALL() {
        List<PaisProvinciaCiudad> list = new ArrayList();
        try {
            ResultSet result = getResultSetSelectAll(TABLA);
            while (result != null && result.next()) {
                PaisProvinciaCiudad paisProvinciaCiudad = new PaisProvinciaCiudad();
                
                int resId = result.getInt(COLUMNA_ID);
                String resPais = result.getString(COLUMNA_PAIS);
                String resProvincia = result.getString(COLUMNA_PROVINCIA);
                String resLocalidad = result.getString(COLUMNA_LOCALIDAD);
                
                
                paisProvinciaCiudad.setId(resId);
                paisProvinciaCiudad.setPais(resPais);
                paisProvinciaCiudad.setProvincia(resProvincia);
                paisProvinciaCiudad.setLocalidad(resLocalidad);
                
                list.add(paisProvinciaCiudad);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los usuarios");
            e.printStackTrace();
        }
        return list;
    }
    
    
}
