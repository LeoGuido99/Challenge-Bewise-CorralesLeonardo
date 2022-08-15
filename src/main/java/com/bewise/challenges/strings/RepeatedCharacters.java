package com.bewise.challenges.strings;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashSet;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
        return this.caracteresRepetidos(cadena);
    }
	
	private Boolean caracteresRepetidos(String cadena) {
		String cadenaSinEspacioes = cadena.replaceAll("\\s+",""); // saca los espacios
		char unaLetra;
		int posicion = 0;
		int contador = 0;
		
		List<Integer> listaDeContadores = new ArrayList<Integer>(); // creo una lista de contadores
		
		for(int i = 0; i<cadenaSinEspacioes.length();i++) {
			unaLetra = cadenaSinEspacioes.toCharArray()[i]; 
			
			 posicion = cadena.indexOf(unaLetra);
		        while (posicion != -1) { //mientras se encuentre el caracter
		            contador++;           //se cuenta
		            //se sigue buscando a partir de la posición siguiente a la encontrada                                 
		            posicion = cadena.indexOf(unaLetra, posicion + 1);
		        }
		      
			
			listaDeContadores.add(contador); //añade a la lista para saber cuanto se repite cada caracter ej: "aabbb" sera una lista de [2,2,3,3,3]
			contador = 0; // vuelve el contador a cero para seguir con el siguiente caracter de la cadena[i]
			
		}
		
		listaDeContadores = listaDeContadores.stream().distinct().collect(Collectors.toList()); // elimina los repetidos

		boolean sonIguales = new HashSet<>(listaDeContadores).size() == 1; // funcion que chequea que todos los elementos de la lista son iguales
		
		return sonIguales || (this.hayCaracterExcepcion(listaDeContadores) && this.todosIgualesConExcepcion(listaDeContadores));
	}
	
	
	private Boolean hayCaracterExcepcion(List<Integer> listaDeContadores) {	
		for(int i = 1;i<listaDeContadores.size();i++) {
			
			return listaDeContadores.get(0) == (listaDeContadores.get(i) + 1) || listaDeContadores.get(0) == (listaDeContadores.get(i) - 1); 
			// si encuentra que un contador es igual al contado+1 o -1 devuelve true
		}
		
		return false;
	}
	
	private Boolean todosIgualesConExcepcion(List<Integer> listaDeContadores) {
		int contadorDeElementosIguales = 0;
		
		for(int i = 0;i<listaDeContadores.size();i++) {
			if(listaDeContadores.get(0) == listaDeContadores.get(i)) {
				contadorDeElementosIguales++; // cuenta los contadores que son iguales dentro de la lista
			}
		}
		
		return contadorDeElementosIguales == (listaDeContadores.size() - 1);// como hay uno que es distinto(por ser caracte exepcion) comparo con el size() - 1
	}
	

	
}





