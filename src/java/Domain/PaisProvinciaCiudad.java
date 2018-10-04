/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author ElViru
 */
public class PaisProvinciaCiudad {
    
    private int id;
    private String pais;
    private String provincia;
    private String localidad;

    public int getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public PaisProvinciaCiudad(int id, String pais, String provincia, String localidad) {
        this.id = id;
        this.pais = pais;
        this.provincia = provincia;
        this.localidad = localidad;
    }

    public PaisProvinciaCiudad() {
    }

    
    
    @Override
    public String toString() {
        return "PaisProvinciaCiudad{" + "pais=" + pais + ", provincia=" + provincia + ", ciudad=" + localidad + '}';
    }
    
    public String toStringPais() {
        return pais ;
    }
    
    public String toStringProvincia() {
        return provincia ;
    }
    
    public String toStringLocalidad() {
        return localidad ;
    }
    
    
    
}
