/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marcelosiedler
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/webservice";
    /**
     * O atributo driver representa a classe do Driver JDBC que será usada na 
     * conexão. Quando se utiliza outros bancos usa-se a classe apropriada a 
     * cada banco
     */
    private static final String driver = "com.mysql.jdbc.Driver";
    /**
     * Os atributos usuario e senha representam usuario e senha do 
     * SGBD a ser usado na conexão
     */
    private static final String usuario = "root";
    private static final String senha = "";  
    /**
     * O atributo con representa um objeto que 
     * contém a conexão com o banco de dados em si
     */
    private static Connection con = null;
    
    /**
     * Metodo que retorna uma conexão com o banco de dados
     * @return objeto java.sql.Connection
     */
    public Connection conectar(){
        // primeiro testo se o objeto con não foi inicializado
        if (con == null){
            try {
                // defino a classe do driver a ser usado
                Class.forName(driver);
                // criação da conexão com o BD
                con = DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver...Erro: "+ex);
                return null;
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar no banco: "+ ex.getMessage());
                return null;
            }
        }
        return con;
    }
    /**
     * Método que recebe um comando SQL para ser executado
     * @param sql
     * @return um objeto java.sql.PreparedStatement
     */
    public PreparedStatement getPreparedStatement(String sql){
        // testo se a conexão já foi criada
        if (con == null){
            // cria a conexão
            con = conectar();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+
                    e.getMessage());
        }
        return null;
    }
    
}
