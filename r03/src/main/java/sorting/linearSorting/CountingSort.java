package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array.equals(null)) {
			return;
		}
		if(leftIndex < 0) {
			leftIndex = 0;
		}
		if(rightIndex > array.length -1) {
			rightIndex = array.length -1;
		}
		if(leftIndex > rightIndex) {
			return;
		}
		Integer[] aux = new Integer[descobreMaior(array) + 1];
		Integer[] arraySaida = new Integer[array.length];
		
		for(int i = 0; i < aux.length; i++) {
			aux[i] = 0;
		}
		
		for(int i = 0; i < array.length; i++) {
			aux[array[i]]++;
		}
		
		for(int i = 1; i < aux.length; i++) {
			aux[i] += aux[i - 1];
		}
		
		for(int i = 0; i < array.length; i++) {
			arraySaida[aux[array[i]]-- -1] = array[i];
		}
		
		for(int i = 0; i <  array.length; i++ ) {
			array[i] = arraySaida[i];
		}
	}
	
	public Integer descobreMaior(Integer[] array) {
		if(array.length >= 1) {
			int maior = array[0];
			for(int i = 0; i < array.length; i++) {
				if(array[i] > maior) {
					maior = array[i];
				}
			}
			return maior;
		}
		return null;
		
	}

}
