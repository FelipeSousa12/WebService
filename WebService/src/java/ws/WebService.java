/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import conexao.Conexao;
import dao.Dao;
import dao.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import models.Anuncio;
import models.Empresa;
import models.Usuario;

/**
 * REST Web Service
 *
 * @author Felipe
 */
@Path("generic")
public class WebService {
    
    Conexao con = new Conexao();
    Gson g = new Gson();
    UsuarioDAO dao = new UsuarioDAO();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService
     */
    public WebService() {
    }

    /**
     * Retrieves representation of an instance of ws.WebService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("web/buscar/{name}")
    public String buscar(@PathParam("name") String nome) {
        Usuario usu = new Usuario();
        usu.setNome(nome);

        usu = dao.buscar(usu);

        return g.toJson(usu);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("web/listar")
    public String listar() {
        List<Usuario> lista = new ArrayList<Usuario>();

        UsuarioDAO dao = new UsuarioDAO();
        lista = dao.listar();

        return g.toJson(lista);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("web/pesquisarGps/lat/{lati}/long/{long}")
    public String pesquisarGps(@PathParam("lati") String lati, @PathParam("long") String longi) {
        List<Empresa> lista = new ArrayList<Empresa>();
        List<Anuncio> listaimg = new ArrayList<Anuncio>();

        Dao daoo = new Dao();
        lista = daoo.listarEmp();

        for (Empresa emp : lista) {
            if ((emp.getLatitudeEmpresa().equals(lati)) && (emp.getLongitudeEmpresa().equals(longi))) {
                return emp.getNomeEmpresa();
            }
        }
        return "Erro ao enviar";
    }

    @DELETE
    @Path("web/excluir/{name}")
    public boolean excluir(@PathParam("name") String nome) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);

        return dao.excluir(usuario);
    }

    /**
     * PUT method for updating or creating an instance of WebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("web/inserir/{json}")
    public boolean inserir(@PathParam("json") String content) {
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        return dao.inserir(u);
    }
}
