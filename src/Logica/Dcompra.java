/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author RAMIREZ
 */
class Dcompra {
    //PENDIIIING??
    private String IdCompra;
    private String IdMateriaPrima;
    private String IdProveedor;
    private int CantidadCompra;
    
    //private int IdUsuario;
    private String SubtotalVenta;
    private String IvaVenta;
    private String TotalVenta;
    private String FechaVenta;

    public Dcompra(String IdVenta, int IdUsuario, String SubtotalVenta, String IvaVenta, String TotalVenta, String FechaVenta) {
        this.IdVenta = IdVenta;
        this.IdUsuario = IdUsuario;
        this.SubtotalVenta = SubtotalVenta;
        this.IvaVenta = IvaVenta;
        this.TotalVenta = TotalVenta;
        this.FechaVenta = FechaVenta;
    }
}
