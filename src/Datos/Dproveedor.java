/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

/**
 *
 * @author vitela
 */
public class Dproveedor {
    private int idproveedor;
    private String nombre;
    private String direccion;
    private String telefonop;
    private String celularp;

    public Dproveedor(int idproveedor, String nombre, String direccion, String telefonop, String celularp) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonop = telefonop;
        this.celularp = celularp;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonop() {
        return telefonop;
    }

    public void setTelefonop(String telefonop) {
        this.telefonop = telefonop;
    }

    public String getCelularp() {
        return celularp;
    }

    public void setCelularp(String celularp) {
        this.celularp = celularp;
    }
  



    public Dproveedor() {
    }


//    
}
