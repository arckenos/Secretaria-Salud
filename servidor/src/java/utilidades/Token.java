/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import entidades.Pacientes;
import entidades.TrabajadorSalud;

/**
 *
 * @author Arcke
 */
public class Token {
    private TrabajadorSalud destinatario;
    private Pacientes remitente;
    private String tiempo;    
    private boolean esValido;

    public Token(TrabajadorSalud destinatario, Pacientes remitente, String tiempo, boolean caducado) {
        this.destinatario = destinatario;
        this.remitente = remitente;
        this.tiempo = tiempo;
        this.esValido = caducado;
    }
    
   
    public TrabajadorSalud getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(TrabajadorSalud destinatario) {
        this.destinatario = destinatario;
    }

    public Pacientes getRemitente() {
        return remitente;
    }

    public void setRemitente(Pacientes remitente) {
        this.remitente = remitente;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isCaducado() {
        return esValido;
    }

    public void setCaducado(boolean caducado) {
        this.esValido = caducado;
    }
    
    
}
