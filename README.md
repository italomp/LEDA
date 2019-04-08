# LEDA
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
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if(array.equals(null) || array.length == 0) {
			return null;
		}
		if(k > array.length -1) {
			return null;
		}
		int ordem = 0;
		T menorAtual = array[0];
		while(ordem < k) {
			menorAtual = selecionaKesimoMenor(array, menorAtual);
			ordem++;
		}
		return menorAtual;
	}
	
	public T selecionaKesimoMenor(T[] array, T menorAtual) {
		T menor = array[0];
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j < array.length; j++) {
				if(array[j].compareTo(menorAtual) > 0) {
					if(array[j].compareTo(menor) < 0) {
						menor = array[j];
					}
				}
			}
		}
		return menor;
	}
	
	public static void main(String[] args) {
		OrderStatisticsSelectionImpl teste = new OrderStatisticsSelectionImpl();
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,10};
		Integer[] a2 = {10,9,8,7,6,5,4,3,2,1};
		Integer[] a3 = {5,4,3,2,1,10,9,8,7,6};
		
		//testes em a1
		System.out.println("TESTES A1");
		System.out.println("primeiro menor de a1");
		System.out.println(teste.getOrderStatistics(a1, 1));
		
		System.out.println("quinto menor de a1");
		System.out.println(teste.getOrderStatistics(a1, 5));
		
		System.out.println("decimo menor de a1");
		System.out.println(teste.getOrderStatistics(a1, 10));
		
		//testes em a2
		System.out.println("TESTES A2");
		System.out.println("primeiro menor de a2");
		System.out.println(teste.getOrderStatistics(a2, 1));
		
		System.out.println("quinto menor de a2");
		System.out.println(teste.getOrderStatistics(a2, 5));
		
		System.out.println("decimo menor de a2");
		System.out.println(teste.getOrderStatistics(a2, 10));
		
		//testes em a3
		System.out.println("TESTES A3");
		System.out.println("primeiro menor de a3");
		System.out.println(teste.getOrderStatistics(a3, 1));
		
		System.out.println("quinto menor de a3");
		System.out.println(teste.getOrderStatistics(a3, 5));
		
		System.out.println("decimo menor de a3");
		System.out.println(teste.getOrderStatistics(a3, 10));
		
		
	}
	
	
}
