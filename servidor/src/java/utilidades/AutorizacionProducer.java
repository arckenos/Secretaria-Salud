/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import entidades.Citas;
import entidades.service.CitasFacadeREST;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Arcke
 */
public class AutorizacionProducer {
    
    public static void enviarAuth(String citaJson){
        Gson gson =new Gson();
        Citas cita = gson.fromJson(citaJson.toString(), Citas.class);
        
       
        
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try ( Connection connection = factory.newConnection();  
                Channel channel = connection.createChannel()) {
             Token token = new Token(cita.getIdTrabajadorSalud(), cita.getIdPaciente(), "1000", true);    
                   String topico = token.getDestinatario().getCedulaProfesional();
                   channel.exchangeDeclare(topico, "fanout");
                  
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(bos);
                    oos.writeObject(token);
                    oos.flush();
                    byte [] data = bos.toByteArray();
                    channel.basicPublish(topico, "", null, data);
                    System.out.println(" Enviando acceso de token  a" + topico +"'");
                       
        } catch (IOException | TimeoutException ex) {}
    }
}
