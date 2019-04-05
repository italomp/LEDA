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
		int tamanhoAux = Math.abs(maior - menor) + 1;
		Integer[] aux = new Integer[tamanhoAux];
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
	
	public static void main(String[] args) {
		Integer[] a1 = {6,5,4,7,9,8,2,1,3};
		Integer[] a2 = {6,-5,4,-7,-9,8,2,1,3};
		Integer[] a3 = {6,-5,4,-7,0,8,2,1,3};
		
		ExtendedCountingSort sort = new ExtendedCountingSort();
		
		sort.sort(a1, 0, 8);
		sort.sort(a1, 0, 8);
		sort.sort(a1, 0, 8);
		
		for(int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < a3.length; i++) {
			System.out.print(a3[i] + " ");
		}
		
	}

}
