/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consumer;

import clientetrabajadorsalud.ClienteTrabajadorSalud;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Token;

/**
 *
 * @author Arcke
 */
public class ConsumerAccesos {
    public static List<Token> accesos = new ArrayList<>();
    private final static String QUEUE_NAME = "hello";
    private static String EXCHANGE_NAME = "CDP12345";
    
    public static void iniciarConsumer(String cedula) throws Exception{
        EXCHANGE_NAME = cedula;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" Listo para recibir tokens de acceso con la cedula "+ EXCHANGE_NAME);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            byte[] data = delivery.getBody();
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            ObjectInputStream is = new ObjectInputStream(in);
            Token token;
            try {
                token = (Token) is.readObject();
                accesos.add(token);
                
                System.out.println(" Recibido token de acceso al expediente de " + token.getRemitente().getNombreCompleto()  + "'");
            } catch (IOException ex) {
                Logger.getLogger(ClienteTrabajadorSalud.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteTrabajadorSalud.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
        
    }
    
}
