package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.equals(null)) {
			return;
		}
		if(leftIndex < 0) {
			leftIndex = 0;
		}
		if(rightIndex > array.length - 1) {
			rightIndex = array.length - 1;
		}
		if(leftIndex > rightIndex) {
			return;
		}
		if(leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		}
	}
	
	public void merge(T[] array, int leftIndex, int mid, int rightIndex) {
		int indiceEsquerda = leftIndex;
		int indiceDireita = mid + 1;
		int indicePrincipal = leftIndex;
		T[] aux = (T[]) new Comparable[array.length];
		
		for(int i = 0; i <= rightIndex; i++) {
			aux[i] = array[i];
		}
		
		while(indiceEsquerda <= mid && indiceDireita <= rightIndex) {
			if(aux[indiceEsquerda].compareTo(aux[indiceDireita]) <= 0) {
				array[indicePrincipal] = aux[indiceEsquerda];
				indiceEsquerda++;
			}
			else {
				array[indicePrincipal] = aux[indiceDireita];
				indiceDireita++;
			}
			indicePrincipal++;
		}
		
		while(indiceEsquerda <= mid) {
			array[indicePrincipal] = aux[indiceEsquerda];
			indicePrincipal++;
			indiceEsquerda++;
		}
		
		while(indiceDireita <= rightIndex) {
			array[indicePrincipal] = aux[indiceDireita];
			indicePrincipal++;
			indiceDireita++;
		}	
	}
}
