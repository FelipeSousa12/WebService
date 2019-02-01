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
public class Empresa {
    private int Id;
    private String NomeEmpresa;
    private String LatitudeEmpresa;
    private String LongitudeEmpresa;
    //DEFINIR BLOCO DE ANUNCIOS OU REFERENCIAR A UMA TABELA

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNomeEmpresa() {
        return NomeEmpresa;
    }

    public void setNomeEmpresa(String NomeEmpresa) {
        this.NomeEmpresa = NomeEmpresa;
    }

    public String getLatitudeEmpresa() {
        return LatitudeEmpresa;
    }

    public void setLatitudeEmpresa(String LatitudeEmpresa) {
        this.LatitudeEmpresa = LatitudeEmpresa;
    }

    public String getLongitudeEmpresa() {
        return LongitudeEmpresa;
    }

    public void setLongitudeEmpresa(String LongitudeEmpresa) {
        this.LongitudeEmpresa = LongitudeEmpresa;
    }
    
    
}
