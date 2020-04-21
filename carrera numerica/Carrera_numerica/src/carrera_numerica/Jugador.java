
package carrera_numerica;


public class Jugador {

    String name;
    int position, pares;
    String estado = "perdedor";
    
    
    public Jugador(String name) {
        this.name = name;
        //this.estado = estado;
    }
    
    public void setNombre(String nom){
        this.name = nom;
    }
    
    public String getNombre(){
        return name;
    }
    
    public void setPosition(int pos){
        this.position += pos;
    }
    
    public int getPosition(){
        return position;
    }
    
    public void setEstado(String est){
        this.estado = est;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setCont(int p){
        this.pares += p;
    }
    
    public int getCont(){
        return pares;
    }
    
    
}
