package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import sorting.divideAndConquer.QuickSort;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * No algoritmo de quicksort, selecionamos um elemento como pivot,
	 * particionamos o array colocando os menores a esquerda do pivot 
	 * e os maiores a direita do pivot, e depois aplicamos a mesma estrategia 
	 * recursivamente na particao a esquerda do pivot e na particao a direita do pivot. 
	 * 
	 * Considerando um array com muitoe elementos repetidos, a estrategia do quicksort 
	 * pode ser otimizada para lidar de forma mais eficiente com isso. Essa melhoria 
	 * eh conhecida como quicksort tree way e consiste da seguinte ideia:
	 * - selecione o pivot e particione o array de forma que
	 *   * arr[l..i] contem elementos menores que o pivot
	 *   * arr[i+1..j-1] contem elementos iguais ao pivot.
	 *   * arr[j..r] contem elementos maiores do que o pivot. 
	 *   
	 * Obviamente, ao final do particionamento, existe necessidade apenas de ordenar
	 * as particoes contendo elementos menores e maiores do que o pivot. Isso eh feito
	 * recursivamente. 
	 **/
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int[] pivots = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivots[0] - 1);
			sort(array, pivots[1] + 1, rightIndex);
		}
	}
	
	public int[] partition(T[] array, int leftIndex, int rightIndex) {
		int curr = leftIndex;
		int pivotPositionLeft = leftIndex;
		int pivotPositionRight = leftIndex;
		int pivot = rightIndex;
		
		while(curr < pivot) {
			if(array[curr].compareTo(array[pivot]) <= 0) {
				Util.swap(array, curr, pivotPositionRight);
				pivotPositionRight++;
			}
			curr++;
		}
		Util.swap(array, pivot, pivotPositionRight);
		curr = pivotPositionRight;
		pivotPositionLeft = curr;
		
		while(curr >= leftIndex) {
			if(array[curr].compareTo(array[pivotPositionRight]) == 0) {
				Util.swap(array, curr, pivotPositionLeft);
				pivotPositionLeft--;
			}
			curr--;
		}
		pivotPositionLeft++;
		int[] result = {pivotPositionLeft, pivotPositionRight};
		return result;
	}
	
	public static void main(String[] args) {
		Integer[] a1 = {10,10,10,1,1,1,2,5,5,5};
		Integer[] a2 = {5,5,5,1,1,1,2,10,10,10};
		Integer[] a3 = {5,5,5,10,10,10,3,3,3,1};
		
		ThreeWayQuickSort threeWay = new ThreeWayQuickSort();
		
		//FULL
		threeWay.sort(a1, 0, a1.length -1);
		threeWay.sort(a2, 0, a2.length -1);
		threeWay.sort(a3, 0, a3.length -1);

		
		//IN RANGE
//		threeWay.sort(a1, 3, 7);
//		threeWay.sort(a2, 3, 7);
//		threeWay.sort(a3, 3, 7);

		System.out.println("A1 POS SORT");
		for(int i = 0; i < a1.length; i++) {
			if(i == a1.length - 1) {
				System.out.println(a1[i]);
			}
			else {
				System.out.print(a1[i] + ", ");
			}
		}
		
		System.out.println("A2 POS SORT");
		for(int i = 0; i < a2.length; i++) {
			if(i == a2.length - 1) {
				System.out.println(a2[i]);
			}
			else {
				System.out.print(a2[i] + ", ");
			}
		}
		
		System.out.println("A3 POS SORT");
		for(int i = 0; i < a3.length; i++) {
			if(i == a3.length - 1) {
				System.out.println(a3[i]);
			}
			else {
				System.out.print(a3[i] + ", ");
			}
		}
	}

}
