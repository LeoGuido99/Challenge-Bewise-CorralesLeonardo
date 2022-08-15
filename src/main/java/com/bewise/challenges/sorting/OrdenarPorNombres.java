package com.bewise.challenges.sorting;

import java.util.Comparator;

public class OrdenarPorNombres implements Comparator<Jugador>{

	@Override
	public int compare(Jugador jugador1, Jugador jugador2) {
		// TODO Auto-generated method stub
		return  jugador1.getNombre().compareTo(jugador2.getNombre());
	}

}
