package ordenacao;

public class CoutingSort {
	
	public int maiorElemento(Integer[] array) {
		int maior = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
	}
	
	public int menorElemento(Integer[] array) {
		int menor = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] < menor) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	public Integer[] sort(Integer[] arrayEntrada) {
		Integer[] arraySaida, arrayAux;
		arraySaida = new Integer[arrayEntrada.length];
		
		//descobrir maior e menor elementos, para saber o tamanho do array C
		int maior = maiorElemento(arrayEntrada);
		int menor = menorElemento(arrayEntrada);
		
		//craindo array C, com tamanho do maior elemento + 1
		//e preenchedo-o com zeros
		arrayAux = new Integer[maior + 1];
		
		for(int i = 0; i < arrayAux.length; i++) {
			arrayAux[i] = 0;
		}
		
		//contando. Percorrer A, contando em C
		for(int i = 0; i < arrayEntrada.length; i++) {
			arrayAux[arrayEntrada[i]]++;
		}
		
		//somando os prefixos
		for(int i = 1; i < arrayAux.length; i++) {
			arrayAux[i] = arrayAux[i] + arrayAux[i - 1];
		}
		
		//ordenação. percorrer o A de tras para frente
		//Elemento de array de entrada, será a chave do arrayAux
		//Elemento do arrayAux, menos 1, será indice do arraySaida
		//O que serah adicionado no arraySaida eh o indice do arrayAux
		for(int i = 0; i < arrayEntrada.length; i++) {
			arraySaida[arrayAux[arrayEntrada[i]]-- - 1] = arrayEntrada[i];
		}
		
		return arraySaida;
	}
	
	public static void main(String[] args) {
		CoutingSort couting = new CoutingSort();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		
		Integer[] novoA1 = couting.sort(a1);
		Integer[] novoA2 = couting.sort(a2);
		Integer[] novoA3 = couting.sort(a3);
		Integer[] novoA4 = couting.sort(a4);
		
		for(int i = 0; i < novoA1.length; i++) {
			System.out.print(novoA1[i] + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < novoA2.length; i++) {
			System.out.print(novoA2[i] + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < novoA3.length; i++) {
			System.out.print(novoA3[i] + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < novoA4.length; i++) {
			System.out.print(novoA4[i] + ", ");
		}
		System.out.println();	
	}
}
