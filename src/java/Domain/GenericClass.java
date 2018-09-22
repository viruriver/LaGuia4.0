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
public class GenericClass {
    private int id;
    private String desc;

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public GenericClass(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public GenericClass(int id) {
        this.id = id;
    }

    public GenericClass(String desc) {
        this.desc = desc;
    }

    public GenericClass() {
    }

    
}
