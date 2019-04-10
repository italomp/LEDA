package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao..
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {	
		T menor = selectionSmaller(array);
		if(k == 1) {
			return menor;
		}
		else {
			int order = 2;
			return getOrderStatisticsAux(array, k, order, menor);
		}
	}
	
	public T getOrderStatisticsAux(T[] array, int k, int order, T menor) {
		T elementK = selectionSmallerK(array, menor);
		if(order == k) {
			return elementK;
		}
		else {
			return getOrderStatisticsAux(array, k, order + 1, elementK);
		}
	}
	
	/**
	 * unica responsabilidade: achar o menor elemento, maior que o atual menor.
	 * 
	 */
	public T selectionSmallerK(T[] array, T menor) {
		T smaller = selectionBigger(array);
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(menor) > 0) {
				if(array[i].compareTo(smaller) < 0) {
					smaller = array[i];
				}
			}
		}
		return smaller;
	}
	
	public T selectionSmaller(T[] array) {
		T smaller = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(smaller) < 0) {
				smaller = array[i];
			}
			
		}
		return smaller;	
	}
	
	public T selectionBigger(T[] array) {
		T bigger = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(bigger) > 0) {
				bigger = array[i];
			}
		}
		return bigger;	
	}
	
	public static void main(String[] args) {
		OrderStatisticsSelectionImpl teste = new OrderStatisticsSelectionImpl();
		
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,10};
		Integer[] a2 = {10,9,8,7,6,5,4,3,2,1};
		Integer[] a3 = {5,4,3,2,1,10,9,8,7,6};		
		System.out.println("A1");
		System.out.println("k = 1");
		System.out.println(teste.getOrderStatistics(a1, 1));
		System.out.println("k = 5");
		System.out.println(teste.getOrderStatistics(a1, 5));
		System.out.println("k = 10");
		System.out.println(teste.getOrderStatistics(a1, 10));
		
		System.out.println("A2");
		System.out.println("k = 1");
		System.out.println(teste.getOrderStatistics(a2, 1));
		System.out.println("k = 5");
		System.out.println(teste.getOrderStatistics(a2, 5));
		System.out.println("k = 10");
		System.out.println(teste.getOrderStatistics(a2, 10));
		
		System.out.println("A3");
		System.out.println("k = 1");
		System.out.println(teste.getOrderStatistics(a3, 1));
		System.out.println("k = 5");
		System.out.println(teste.getOrderStatistics(a3, 5));
		System.out.println("k = 10");
		System.out.println(teste.getOrderStatistics(a3, 10));
	}


}
