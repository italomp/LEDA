package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
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
			int pivotDireita = partition(array, leftIndex, rightIndex);
			int pivotEsquerda = descobrePivotEsquerda(array, leftIndex,
					pivotDireita);
			sort(array, leftIndex, pivotEsquerda - 1);
			sort(array, pivotDireita + 1, rightIndex);
		}
	}
	
	/**
	 * 	metodo auxiliar que descobre o elemento igual ao pivot mais a esquerda
	 *	do centro do array.
	 *	Os elementos iguais ao pivot precisam estar adjacenetes. 
	 *	E quando este metodo eh chamado, os elementos iguais ao pivot jah estao
	 *	adjacentes.
	 *
	 * @param array
	 * @param leftIndex
	 * @param pivotDireita
	 * @return primeiro elemento igual ao pivot da esquerda para direita (pivotEsquerda). 
	 */
	public int descobrePivotEsquerda(T[] array, int leftIndex, 
			 int pivotDireita) {
		int retorno = leftIndex;
		for(int i = leftIndex; i <= pivotDireita; i++) {
			if(array[i].compareTo(array[pivotDireita]) == 0) {
				retorno = i;
				return retorno;
			}
		}
		return retorno;
	}
	
	/**
	 * Inicialmente um partition tradicional, onde todos os elementos
	 * menores ou iguais ao pivot ficam a esquerda do pivot. E posteriormente
	 * todos os elementos iguais ao pivot sao levados para posicoes adjacentes
	 * a do pivot.
	 * 
	 * @param array
	 * @param leftIndex
	 * @param rightIndex
	 * @return
	 */
	public Integer partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[rightIndex];
		int posicaoPivot = leftIndex;
		int i = leftIndex;
		
		while(i < rightIndex) {
			if(array[i].compareTo(pivot) <= 0) {
				Util.swap(array, posicaoPivot, i);
				posicaoPivot++;
			}
			i++;
		}
		Util.swap(array, posicaoPivot, rightIndex);
		
		int iAux = leftIndex;
		int posicaoPivotEsquerda = posicaoPivot - 1;
		while(iAux < posicaoPivotEsquerda) {
			if(array[iAux].compareTo(array[posicaoPivot]) == 0) {
				Util.swap(array, iAux, posicaoPivotEsquerda);
				posicaoPivotEsquerda--;
			}
			iAux++;
		}
		
		return posicaoPivot;
	}

}
