package carrera_numerica;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Carrera_numerica {

    
    
    public static void main(String[] args) {
        
        Scanner ingresar = new Scanner(System.in);
        boolean estado_juego = true;
       
        System.out.println("ingrese cantidad de jugadores");
        int players = ingresar.nextInt();
        
        
        //validacion de numero de jugadores
        while(true){
            if(players<2||players>4){
                System.out.println("Solo se pueden ingresar entre 2 y 4 jugadores"); 
                try {
                    players = ingresar.nextInt();
                } catch (InputMismatchException e) {  
                        
                    System.out.println("no es un valor numerico correcto ó \n"
                            + "no es un valor numérico");
                    System.out.println(e);
                }  
            }
            else{
                break;
            }
        }
            
            
             
            
        
        
        System.out.println("jugadores ingresados: " + players);
        Jugador player[] = new Jugador[players];
        System.out.println("Ingresa el nombre de los "+ players + " jugadores");
        ingresar.nextLine();
        
        createUser(player);
        
        nivelTablero();
        
        
        Tablero tablero = new Tablero(" ");
        int position_tab;
        int option = ingresar.nextInt();
        switch(option){
            case 1:
                
                tablero.setNivel("básico");
                
                position_tab=20;
                
                juego(player, tablero, position_tab, estado_juego);
                break;
            case 2:
                tablero.setNivel("intermedio");
                position_tab=30;
                tablero.setPotitions(position_tab);
                
                juego(player, tablero, position_tab, estado_juego);
                
                break;
            case 3:
                tablero.setNivel("avanzado");
                position_tab=50;
                tablero.setPotitions(position_tab);
                juego(player, tablero, position_tab, estado_juego);
                break;                  
        }
        
        for (int i = 0; i < player.length; i++) {
            System.out.println("=========================================");
            System.out.println("Jugador: " + player[i].getNombre());
            System.out.println("Posición: " + player[i].getPosition());
            System.out.println("Estado: " + player[i].getEstado());
            System.out.println("Tipo de tablero jugado: " + tablero.getNivel());
            System.out.println("Posiciones del tablero jugado: " + tablero.getPosition());
            System.out.println("==========================================");
        }  
    }
    
    public static void waiting(){
        try {
            Thread.sleep(3*1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static int tirarDados(){
        int d1 = (int)(Math.random()*6+1);
        int d2 = (int)(Math.random()*6+1);
        
    return d1+d2;
    }
    
    public static void createUser(Object[] player){
        Scanner ingresar = new Scanner(System.in);
        for (int i = 0; i < player.length; i++) {
            System.out.println("Ingrese jugador: "+ (i+1));
            String nombre = ingresar.nextLine();
            player[i] = new Jugador(nombre);
        }
    }
    
    public static void nivelTablero(){
        System.out.println("Ingresar nivel del tablero\n"+
                "1. Nivel básico\n"+
                "2. Nivel intermedio\n"+
                "3. Nivel avanzado\n");
    }
    
    public static void juego(Object[] player,Object tablero, int nt,boolean ej){
        Tablero t = (Tablero)tablero;
        String nombre;
        
        int contador_pares;
        int posicion;
        t.setPotitions(nt);
                do{
                    for (int i = 0; i < player.length; i++) {
                        nombre = ((Jugador)player[i]).getNombre();
                        posicion = ((Jugador)player[i]).getPosition();
                        
                        
                        if(posicion>=t.getPosition()){
                            ej = false;
                            System.out.println("Ha ganado: "+ nombre);
                            ((Jugador)player[i]).setEstado("Ganador");
                            break;
                        }
                        else{
                            System.out.println("nombre jugador: "+ nombre );
                            System.out.println("posición "+ posicion);
                            System.out.println("Tirando dados...");

                            waiting();

                            int al = tirarDados();
                            //verificar si el numero aleatorio es par
                            
                            System.out.println("Avanza "+ al + " posiciones");
                            ((Jugador)player[i]).setPosition(al);
                            if(al %2 == 0){
                                ((Jugador)player[i]).setCont(1);
                                System.out.println("Ha reunido: " + ((Jugador)player[i]).getCont());
                            }
                            else{
                                ((Jugador)player[i]).setCont(-((Jugador)player[i]).getCont());
                            }
                            if(((Jugador)player[i]).getCont() == 3){
                                ej = false;
                                System.out.println("Ha acumulado 3 pares gana: "+ nombre);
                                ((Jugador)player[i]).setEstado("Ganador");
                                break;
                            }
                            
                            
                            if(posicion>=t.getPosition()){
                                ej = false;
                                System.out.println("Ha ganado: "+ nombre);
                                ((Jugador)player[i]).setEstado("Ganador");
                                break;
                            }
                        }
                        
                    }
                }while(ej==true);
    }
    
    
    
}
