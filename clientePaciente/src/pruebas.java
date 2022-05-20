
import com.fasterxml.jackson.databind.util.JSONPObject;
import entidades.Citas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import servicios.clienteCitas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template


/**
 *
 * @author Arcke
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        clienteCitas svc = new clienteCitas();
        Citas cita = svc.find_JSON(Citas.class, "1");
        System.out.println(cita.getIdPaciente().getNombreCompleto());
        
     
    }
    
}
