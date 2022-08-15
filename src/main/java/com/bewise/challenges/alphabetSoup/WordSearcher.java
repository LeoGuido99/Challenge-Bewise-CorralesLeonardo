package com.bewise.challenges.alphabetSoup;

import java.util.ArrayList;
import java.util.List;

public class WordSearcher {

    private char soup[][];

    public WordSearcher(char soup[][]) {
        this.soup = soup;
    }
    
    public boolean isPresent(String word){
        
    	char[] letrasBuscadas = word.toCharArray(); //convierte el String a un array de chars para buscar letra por letra
        boolean palabraEncontrada = false;

        int filas = this.soup.length;//Tamaño de las filas
        int columnas = this.soup[0].length;//Tamaño de las columnas podria ser soup[1],soup[2] etc es fijo

        int indiceLetra = 0;//arranca por el 0
        List<String> listaDeFilaColumna = new ArrayList<String>();
        
        busqueda:
        	
        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                palabraEncontrada = letraEncontrada(letrasBuscadas, indiceLetra, i, j, listaDeFilaColumna);//recorre la matriz buscando letras
                if(palabraEncontrada) {//cuando es true rompe la busqueda
                	break busqueda; 
                }
                
            }
        }
        
        return palabraEncontrada; //Aca retorna falso o verdadero dependiendo si la encontro o no
    }

    private boolean letraEncontrada(char[] letrasBuscadas, int indiceLetra, int i, int j, List<String> listaDeFilaColumna) {
        boolean palabraEncontrada = false;

        if (letrasBuscadas[indiceLetra] == this.soup[i][j]) {//indice arranca en 0 empieza comparando el char de la fila 0 con la matriz en 0 y 0

            listaDeFilaColumna.add(i +"-"+ j);//cuando coincide añade a la lista de strings quedando por ejemplo {"0-0","0-1",...} [[fila-columna]]

            if(indiceLetra == letrasBuscadas.length-1){
                return true; //cuando el indice del array de letras es igual a la longitud(-1 porque el indice arranca en 0) de la palabra buscada quiere decir que la encontro
            }
            indiceLetra++;//Aumenta el indice luego de meter a la lista de strings

            int filaSiguiente = i + 1;
            int filaAnterior = i - 1;
            int columnaSiguiente = j + 1;
            int columnaAnterior = j - 1;
            int ultimaFila = this.soup.length - 1;
            int ultimaColumna = this.soup[0].length - 1;
            
            //Verticales de arriba hacia abajo o abajo hacia arriba
            if (filaSiguiente <= ultimaFila && !listaDeFilaColumna.contains(filaSiguiente + "-" + j)) {//["0-0"] contiene ["1-0"]
                palabraEncontrada =  letraEncontrada(letrasBuscadas, indiceLetra, filaSiguiente, j, listaDeFilaColumna);// usa recursividad para chequear las otras filas o columnas
            }
            if (filaAnterior >= 0 && !palabraEncontrada && !listaDeFilaColumna.contains(filaAnterior + "-" + j)) {
                palabraEncontrada =  letraEncontrada(letrasBuscadas, indiceLetra, i - 1, j, listaDeFilaColumna);
            }
            
            //Horizontales de izquierda a derecha o derecha a izquierda
            if (columnaSiguiente <= ultimaColumna && !palabraEncontrada && !listaDeFilaColumna.contains(i + "-" + columnaSiguiente)) {
                palabraEncontrada =  letraEncontrada(letrasBuscadas, indiceLetra, i, columnaSiguiente, listaDeFilaColumna);
            }
            if (columnaAnterior >= 0 && !palabraEncontrada && !listaDeFilaColumna.contains(i + "-" + columnaAnterior)) {
                palabraEncontrada = letraEncontrada(letrasBuscadas, indiceLetra, i, columnaAnterior, listaDeFilaColumna);
            }
            
            //Diagonales
            if (filaSiguiente <= ultimaFila && columnaSiguiente <= ultimaColumna && !palabraEncontrada && !listaDeFilaColumna.contains(filaSiguiente + "-" + columnaSiguiente)) {
                palabraEncontrada =  letraEncontrada(letrasBuscadas, indiceLetra, filaSiguiente, columnaSiguiente, listaDeFilaColumna);
            }
            if (filaAnterior >= 0 && columnaAnterior >= 0 && !palabraEncontrada && !listaDeFilaColumna.contains(filaAnterior + "-" + columnaAnterior)) {
                palabraEncontrada =  letraEncontrada(letrasBuscadas, indiceLetra, filaAnterior, columnaAnterior, listaDeFilaColumna);
            } 
        } 
        
        return palabraEncontrada; //devuleve false
    }
}