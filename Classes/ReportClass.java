/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

/**
 *
 * @author yosin
 */
public class ReportClass{
    
    private static int cont = 1;
    private int id;
    private String nombre;
    private String observacionCliente;
    private String obervacionAdministrador;
    private String estado;
    ReportClass sig;
    ReportClass ant;

    public ReportClass(String nombre, String observacionCliente, String obervacionAdministrador, String estado) {
        this.id= cont;
        this.nombre = nombre;
        this.observacionCliente = observacionCliente;
        this.obervacionAdministrador = obervacionAdministrador;
        this.estado = estado;
        cont++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = (int) (Math.random()*99+1);;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservacionCliente() {
        return observacionCliente;
    }

    public void setObservacionCliente(String observacionCliente) {
        this.observacionCliente = observacionCliente;
    }

    public String getObervacionAdministrador() {
        return obervacionAdministrador;
    }

    public void setObervacionAdministrador(String obervacionAdministrador) {
        this.obervacionAdministrador = obervacionAdministrador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
