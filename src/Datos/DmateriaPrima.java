/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author alee
 */
public class DmateriaPrima {
    private String Categoria;
    private String Proveedor;
    private int ID;
    private int Cantidad;
    private String Unidad_medidad;
    private String Producto;
    private String Descripcion;
    private Double Precio;
    private String Fecha_compra;
    private String Fecha_cad;

    public DmateriaPrima(String Categoria, String Proveedor, int ID, int Cantidad, String Unidad_medidad, String Producto, String Descripcion, Double Precio, String Fecha_compra, String Fecha_cad) {
        this.Categoria = Categoria;
        this.Proveedor = Proveedor;
        this.ID = ID;
        this.Cantidad = Cantidad;
        this.Unidad_medidad = Unidad_medidad;
        this.Producto=Producto;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Fecha_compra = Fecha_compra;
        this.Fecha_cad = Fecha_cad;
    }

    public DmateriaPrima() {
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getUnidad_medidad() {
        return Unidad_medidad;
    }

    public void setUnidad_medidad(String Unidad_medidad) {
        this.Unidad_medidad = Unidad_medidad;
    }
    
    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public String getFecha_compra() {
        return Fecha_compra;
    }

    public void setFecha_compra(String Fecha_compra) {
        this.Fecha_compra = Fecha_compra;
    }

    public String getFecha_cad() {
        return Fecha_cad;
    }

    public void setFecha_cad(String Fecha_cad) {
        this.Fecha_cad = Fecha_cad;
    }
    
    
    
    
    
    
    
    
    
}
