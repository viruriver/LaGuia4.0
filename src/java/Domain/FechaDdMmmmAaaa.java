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
public class FechaDdMmmmAaaa {
    
    private int id;
    private String dia;
    private String mes;
    private String año;

    public int getId() {
        return id;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAño() {
        return año;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public FechaDdMmmmAaaa(int id, String dia, String mes, String año) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public FechaDdMmmmAaaa() {
    }

    @Override
    public String toString() {
        return "FechaDDMMMAAAA{" + "id=" + id + ", dia=" + dia + ", mes=" + mes + ", a\u00f1o=" + año + '}';
    }

    public String toStringDia() {
        return dia;
    }

    public String toStringMes() {
        return mes;
    }

    public String toStringAño() {
        return año;
    }
    
    
    
    
}
