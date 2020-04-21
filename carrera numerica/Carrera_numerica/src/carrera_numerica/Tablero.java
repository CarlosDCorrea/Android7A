/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera_numerica;

/**
 *
 * @author usuario
 */
public class Tablero {

    
    //ATTRIBUTES
    
    String nivel;
    int posiciones;
    
    public Tablero(String nivel) {
       this.nivel = nivel;
       
       
    }
    
    
    public String getNivel(){
    return this.nivel;
    }
    
    public void setNivel(String n){
        this.nivel = n;
    }
    
    public int getPosition(){
        return posiciones;
    }
    
    
    public void setPotitions(int pos){
        this.posiciones = pos;
    }
    
    //validar si el nivel es correcto
    
}
