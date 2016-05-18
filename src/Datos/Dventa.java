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
public class Dventa {
    private String IdVenta;
    private int IdUsuario;
    private String SubtotalVenta;
    private String IvaVenta;
    private String TotalVenta;
    private String FechaVenta;

    public Dventa(String IdVenta, int IdUsuario, String SubtotalVenta, String IvaVenta, String TotalVenta, String FechaVenta) {
        this.IdVenta = IdVenta;
        this.IdUsuario = IdUsuario;
        this.SubtotalVenta = SubtotalVenta;
        this.IvaVenta = IvaVenta;
        this.TotalVenta = TotalVenta;
        this.FechaVenta = FechaVenta;
    }

    public String getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(String IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getSubtotalVenta() {
        return SubtotalVenta;
    }

    public void setSubtotalVenta(String SubtotalVenta) {
        this.SubtotalVenta = SubtotalVenta;
    }

    public String getIvaVenta() {
        return IvaVenta;
    }

    public void setIvaVenta(String IvaVenta) {
        this.IvaVenta = IvaVenta;
    }

    public String getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(String TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public Dventa() {
    }
    
    
}
