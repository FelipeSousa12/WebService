/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Empresa;
import models.Gps;
import models.Anuncio;
import conexao.Conexao;

/**
 *
 * @author Felipe
 */
public class Dao {
    
     Conexao con = new Conexao();
     
     public List<Gps> listar(){
        String sql = "SELECT * FROM Gps";
        List<Gps> lista = new ArrayList<Gps>();
        
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
           
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Gps gps = new Gps();
                gps.setId(res.getInt("Id"));
                gps.setLatitude(res.getString("Latitude"));
                gps.setLongitude(res.getString("Longitude"));
                
                lista.add(gps);
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return lista;
 
    }
     
     public List<Anuncio> listarAnuncio(){
        String sql = "SELECT * FROM Imagem";
        List<Anuncio> lista = new ArrayList<Anuncio>();
        
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
           
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Anuncio img = new Anuncio();;
                img.setId(res.getInt("Id"));
                img.setCodigo(res.getString("Codigo"));
                img.setNomeAnuncio(res.getString("NomeAnuncio"));
                
                lista.add(img);
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return lista;
 
    }
     
     public List<Empresa> listarEmp(){
        String sql = "SELECT * FROM empresa";
        List<Empresa> lista = new ArrayList<Empresa>();
        
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
           
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Empresa emp = new Empresa();
                emp.setId(res.getInt("Id"));
                emp.setNomeEmpresa(res.getString("Nome"));
                emp.setLatitudeEmpresa(res.getString("LatitudeEmpresa"));
                emp.setLongitudeEmpresa(res.getString("LongitudeEmpresa"));
                
                lista.add(emp);
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return lista;
 
    }
}
