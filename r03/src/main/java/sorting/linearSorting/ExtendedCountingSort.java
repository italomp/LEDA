package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

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
		int maior = descobreMaior(array);
		int menor = descobreMenor(array);
		Integer[] aux = new Integer[maior - menor + 1];
		Integer[] saida = new Integer[array.length];
		
		for(int i= 0; i < aux.length; i++) {
			aux[i] = 0;
		}
		
		for(int i = 0; i < array.length; i++) {
			aux[array[i] - menor]++;
		}
		
		for(int i = 1; i < aux.length; i++) {
			aux[i] += aux[i - 1];
		}
		
		for(int i = 0; i < array.length; i++) {
			saida[aux[array[i] - menor]-- - 1] = array[i];
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i] = saida[i];
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
	
	public Integer descobreMenor(Integer[] array) {
		if(array.length >= 1) {
			int menor = array[0];
			for(int i = 0; i < array.length; i++) {
				if(array[i] < menor) {
					menor = array[i];
				}
			}
			return menor;
		}
		return null;
	}

}
