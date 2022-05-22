/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import entidades.Pacientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utilidades.AutorizacionProducer;

/**
 *
 * @author Arcke
 */
@Stateless
@Path("entidades.pacientes")
public class PacientesFacadeREST extends AbstractFacade<Pacientes> {

    @PersistenceContext(unitName = "servidorPU")
    private EntityManagerFactory emf;

    public PacientesFacadeREST() {
        super(Pacientes.class);
        emf = Persistence.createEntityManagerFactory("servidorPU");
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Pacientes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Pacientes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pacientes find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pacientes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pacientes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }        

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @POST
    @Path("login")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response iniciarSesion(Pacientes paciente){        
        List<Pacientes> lista =  findAll();
        for (Pacientes pl : lista) {
            if(pl.getCurpPaciente().equals(paciente.getCurpPaciente())){
                if(pl.getContrasenia().equals(paciente.getContrasenia())){
                    String token = crearToken(paciente.getCurpPaciente());
                    return Response.ok(token).build();
                }
            }
        }
        
        
        return Response.noContent().build();
    }
    
    @POST
    @Path("acceso")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void acceso(String citaJson){                    
        //Enviar a rabbit                            
        AutorizacionProducer.enviarAuth(citaJson);
        
        
    }
    
    private String crearToken(String usr){
        String token = null;
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            token = JWT.create().withIssuer("auth0").withClaim("usr", usr).sign(algorithm);
           
        }catch(JWTCreationException exception){} catch (IllegalArgumentException ex) {
            //Logger.getLogger(JWT_filtro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return token;
    }
    
    

    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
}
