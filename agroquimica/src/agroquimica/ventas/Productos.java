/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agroquimica.ventas;

/**
 *
 * @author victor
 */
public class Productos {
    int codpro;
    String nombre;
    double precio;
    int tcantidad;
    int cantidad;
    public Productos(){
    }
    
    public int getCodpro() {
        return codpro;
    }

    public void setCodpro(int codpro) {
        this.codpro = codpro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTcantidad() {
        return tcantidad;
    }

    public void setTcantidad(int tcantidad) {
        this.tcantidad = tcantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
