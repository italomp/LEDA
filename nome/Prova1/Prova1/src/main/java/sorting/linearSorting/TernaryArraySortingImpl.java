package sorting.linearSorting;

import util.Util;

public class TernaryArraySortingImpl<T extends Comparable<T>> implements TernaryArraySorting<T>{
	
	public void sort(T[] ternaryArray) {	
		int contador = 0;
		int atual = 0;
		int prox = atual + 1;
		
		while(contador <= ternaryArray.length - 1) {
			if(ternaryArray[atual].compareTo(ternaryArray[prox]) <= 0) {
				Util.swap(ternaryArray, atual, prox);
				atual++;
				prox++;
			}
			contador++;
			
		}
		
		
		
	}
	
}
