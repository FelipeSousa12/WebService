/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Felipe
 */
public class Anuncio {
     private int id;
     private String NomeAnuncio;
     private String Codigo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAnuncio() {
        return NomeAnuncio;
    }

    public void setNomeAnuncio(String NomeAnuncio) {
        this.NomeAnuncio = NomeAnuncio;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
     
}
