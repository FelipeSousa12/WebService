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
import models.Usuario;
import conexao.Conexao;

/**
 *
 * @author marcelosiedler
 */
public class UsuarioDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    Conexao con = new Conexao();
    
    public UsuarioDAO() {
    }
    
    public boolean inserir(Usuario usuario){
        String sql = "INSERT INTO usuario(nome,login,senha) VALUES(?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
     
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Usuario usuario)
    {
        String sql = "UPDATE usuario set Nome=?,Login=?,Senha=? where Id=?";
        Boolean retorno = false;
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setInt(4, usuario.getId());
           
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public boolean excluir(Usuario usuario){
        String sql = "DELETE FROM usuario where Nome=?";
        boolean retorno = false;
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNome());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
  
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Usuario> listar(){
        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<Usuario>();
        
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
           
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Usuario usu = new Usuario();
                usu.setId(res.getInt("Id"));
                usu.setNome(res.getString("nome"));
                usu.setLogin(res.getString("login"));
                usu.setSenha(res.getString("senha"));
                
                lista.add(usu);
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return lista;
 
    }
    
    public Usuario buscar(Usuario usuario){
        String sql = "SELECT * FROM usuario where Nome=?";
        Usuario usu = null;
        
        PreparedStatement pst = con.getPreparedStatement(sql);
        try {
           
            pst.setString(1, usuario.getNome());
            ResultSet res = pst.executeQuery();
            
            if(res.next()) {
                
                usu = new Usuario();
                usu.setId(res.getInt("Id"));
                usu.setNome(res.getString("Nome"));
                usu.setLogin(res.getString("Login"));
                usu.setSenha(res.getString("Senha"));
 
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return usu;

    }


}
