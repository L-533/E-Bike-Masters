/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author llina
 */
public class GenerarSerie {
    int dato;
    String numero;
    
    public String NumeroSerie(int dato) {
        this.dato = dato + 1;
        numero = String.format("%08d", this.dato);
        return this.numero;
    }
}
