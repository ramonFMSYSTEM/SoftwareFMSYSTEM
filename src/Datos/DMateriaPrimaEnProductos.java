/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author RAMIREZ
 */
public class DMateriaPrimaEnProductos {
    private int id;
    private String idProducto;
    private int idMateriaPrima;
    private String descripcionMP;
    private int cantidadMP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdMateriaPrima() {
        return idMateriaPrima;
    }

    public void setIdMateriaPrima(int idMateriaPrima) {
        this.idMateriaPrima = idMateriaPrima;
    }

    public String getDescripcionMP() {
        return descripcionMP;
    }

    public void setDescripcionMP(String descripcionMP) {
        this.descripcionMP = descripcionMP;
    }

    public int getCantidadMP() {
        return cantidadMP;
    }

    public void setCantidadMP(int cantidadMP) {
        this.cantidadMP = cantidadMP;
    }
    
    
}
