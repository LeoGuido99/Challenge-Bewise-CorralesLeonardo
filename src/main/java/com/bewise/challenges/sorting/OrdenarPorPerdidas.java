package com.bewise.challenges.sorting;

import java.util.Comparator;

public class OrdenarPorPerdidas implements Comparator<Jugador>{

	@Override
	public int compare(Jugador jugador1, Jugador jugador2) {
		// TODO Auto-generated method stub
		
		return jugador1.getPerdidas() - jugador2.getPerdidas();
		
		
	}

}
