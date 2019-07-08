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
		T menor = encontrarMenor(array);
		int order = 1;
		return getOrderStatistics(array, menor, order, k);
	}
	
	public T encontrarMenor(T[] array) {
		T menor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	public T getOrderStatistics(T[] array, T menor, int order, int k) {
		if(order == k) {
			return menor;
		}
		else {
			//sou obrigado a instaciar
			T novoMenor = array[0];
			
			//pegando um menor aleatoreo
			for(int i = 0; i < array.length; i++) {
				if(array[i].compareTo(menor) > 0 ) {
					novoMenor = array[i];
					break;
				}
			}
			
			//selecionando o menor
			for(int i = 0; i < array.length; i++) {
				if(array[i].compareTo(menor) > 0 &&
						array[i].compareTo(novoMenor) < 0) {
					novoMenor = array[i];
				}
			}
			return getOrderStatistics(array, novoMenor, order + 1, k);
		}
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
