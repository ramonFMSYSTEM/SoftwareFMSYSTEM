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
public class Dusuario {
       private int idusuario;
    private String nombreu;
    private String apellidopu;
    private String apellidomu;
    private String telefonou;
    private String direccionu;
   
    private String puestou;
    private String emailu;
    private String contrasenau;

    public Dusuario(int idusuario, String nombreu, String apellidopu, String apellidomu, String telefonou, String direccionu, String puestou, String emailu, String contrasenau) {
        this.idusuario = idusuario;
        this.nombreu = nombreu;
        this.apellidopu = apellidopu;
        this.apellidomu = apellidomu;
        this.telefonou = telefonou;
        this.direccionu = direccionu;
      
        this.puestou = puestou;
        this.emailu = emailu;
        this.contrasenau = contrasenau;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreu() {
        return nombreu;
    }

    public void setNombreu(String nombreu) {
        this.nombreu = nombreu;
    }

    public String getApellidopu() {
        return apellidopu;
    }

    public void setApellidopu(String apellidopu) {
        this.apellidopu = apellidopu;
    }

    public String getApellidomu() {
        return apellidomu;
    }

    public void setApellidomu(String apellidomu) {
        this.apellidomu = apellidomu;
    }

    public String getTelefonou() {
        return telefonou;
    }

    public void setTelefonou(String telefonou) {
        this.telefonou = telefonou;
    }

    public String getDireccionu() {
        return direccionu;
    }

    public void setDireccionu(String direccionu) {
        this.direccionu = direccionu;
    }

   

    public String getPuestou() {
        return puestou;
    }

    public void setPuestou(String puestou) {
        this.puestou = puestou;
    }

    public String getEmailu() {
        return emailu;
    }

    public void setEmailu(String emailu) {
        this.emailu = emailu;
    }

    public String getContrasenau() {
        return contrasenau;
    }

    public void setContrasenau(String contrasenau) {
        this.contrasenau = contrasenau;
    }

    

    
    public Dusuario() {
    }

     
}
