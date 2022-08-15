package com.bewise.challenges.sorting;

import java.util.Collections;
import java.util.List;


public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {
    	Collections.sort(jugadores, new OrdenarPorNombres());//ordena por nombre
    	Collections.sort(jugadores); // ordena por puntuacion
    	
        return jugadores;
    }
    
    

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se segxxuirá usando el
     * nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {
       Collections.sort(jugadores, new OrdenarPorNombres());//ordena por nombre
       Collections.sort(jugadores);//ordena por puntuacion
       Collections.sort(jugadores, new OrdenarPorPerdidas());//ordena por perdidas
      
       return jugadores;
    }
}
