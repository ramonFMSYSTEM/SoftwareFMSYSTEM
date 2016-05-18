/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author MAUPOME
 */
class Dcompra {
    private int IdRegistroCompra;
    private int IdMateriaPrima;
    private int IdProveedor;
    private int IdUsuario;
    private int CantCompra;
    private String FechaCompra;
    private String FechaCaducidad;
    private float IvaCompra;
    
    /**
     * Constructor inicializador
     * @param IdRegistroCompra
     * @param IdMateriaPrima
     * @param IdProveedor
     * @param CantidadCompra
     * @param FechaCompra
     * @param FechaCaducidad
     * @param IdUsuario
     * @param IvaCompra 
     */
    public Dcompra(int IdRegistroCompra, int IdMateriaPrima, int IdProveedor,
            int IdUsuario, int CantidadCompra, String FechaCompra,
            String FechaCaducidad, float IvaCompra) {
        this.IdRegistroCompra = IdRegistroCompra;
        this.IdMateriaPrima = IdMateriaPrima;
        this.IdProveedor = IdProveedor;
        this.CantCompra = CantidadCompra;
        this.FechaCompra = FechaCompra;
        this.FechaCaducidad = FechaCaducidad;
        this.IdUsuario = IdUsuario;
        this.IvaCompra = IvaCompra;
    }
    /**
     * Constructor vacío
     */
    public Dcompra(){
        //EmptySet
    }

    /**
     * @return the IdRegistroCompra
     */
    public int getIdRegistroCompra() {
        return IdRegistroCompra;
    }

    /**
     * @param IdRegistroCompra the IdRegistroCompra to set
     */
    public void setIdRegistroCompra(int IdRegistroCompra) {
        this.IdRegistroCompra = IdRegistroCompra;
    }

    /**
     * @return the IdMateriaPrima
     */
    public int getIdMateriaPrima() {
        return IdMateriaPrima;
    }

    /**
     * @param IdMateriaPrima the IdMateriaPrima to set
     */
    public void setIdMateriaPrima(int IdMateriaPrima) {
        this.IdMateriaPrima = IdMateriaPrima;
    }

    /**
     * @return the IdProveedor
     */
    public int getIdProveedor() {
        return IdProveedor;
    }

    /**
     * @param IdProveedor the IdProveedor to set
     */
    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    /**
     * @return the CantCompra
     */
    public int getCantCompra() {
        return CantCompra;
    }

    /**
     * @param CantCompra the CantCompra to set
     */
    public void setCantCompra(int CantCompra) {
        this.CantCompra = CantCompra;
    }

    /**
     * @return the FechaCompra
     */
    public String getFechaCompra() {
        return FechaCompra;
    }

    /**
     * @param FechaCompra the FechaCompra to set
     */
    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    /**
     * @return the FechaCaducidad
     */
    public String getFechaCaducidad() {
        return FechaCaducidad;
    }

    /**
     * @param FechaCaducidad the FechaCaducidad to set
     */
    public void setFechaCaducidad(String FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }

    /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the IvaCompra
     */
    public float getIvaCompra() {
        return IvaCompra;
    }

    /**
     * @param IvaCompra the IvaCompra to set
     */
    public void setIvaCompra(float IvaCompra) {
        this.IvaCompra = IvaCompra;
    }
    
    
}
