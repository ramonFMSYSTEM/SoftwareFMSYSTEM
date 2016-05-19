/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import java.util.ArrayList;

/**
 *
 * @author vitela
 */
public class Dproducto {
  
    String codigo;
    String categoria;
    String nombre;
    String descripcion;
    String precio;
    String Stock;
    ArrayList<DMateriaPrimaEnProductos> materiasPrimas;
    
    public Dproducto(String codigo, String categoria, String nombre, String descripcion, String precio, String Stock, ArrayList<DMateriaPrimaEnProductos> materiasPrimas) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.Stock = Stock;
        this.materiasPrimas = materiasPrimas;
    }

    public Dproducto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String Stock) {
        this.Stock = Stock;
    }

    public ArrayList<DMateriaPrimaEnProductos> getMateriasPrimas() {
        return materiasPrimas;
    }

    public void setMateriasPrimas(ArrayList<DMateriaPrimaEnProductos> materiasPrimas) {
        this.materiasPrimas = materiasPrimas;
    }
    
}
