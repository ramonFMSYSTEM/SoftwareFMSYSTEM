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
public class DventaDetalle {
    private String IdVenta;
    private String IdProducto;
    private String NombreProducto;
    private String CantidadProducto;
    private String PrecioUnitario;
    private String Total;

    public DventaDetalle(String IdVenta, String IdProducto, String NombreProducto, String CantidadProducto, String PrecioUnitario, String Total) {
        this.IdVenta = IdVenta;
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.CantidadProducto = CantidadProducto;
        this.PrecioUnitario = PrecioUnitario;
        this.Total = Total;
    }

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(String CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public String getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(String PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

    public DventaDetalle() {
    }

    public int getIdUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
