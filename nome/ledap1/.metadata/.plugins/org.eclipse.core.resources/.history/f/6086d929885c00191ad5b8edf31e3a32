package problems;

/**
 * 
 * Dado um array ordenado de elementos comparaveis e um outro elemento comparavel, 
 * implemente o metodo que conte as ocorrências do elemento no array. 
 * 
 * Restricoes:
 * - a complexidade esperada é O (log.n). Soluções com tempo O(n) ou superiores serão desconsideradas.
 * - voce nao pode usar memoria extra
 * - voce nao pode usar metodos prontos da bilbioteca de arrays (exceto o metodo length)
 * - Dica: tente pensar numa forma eficiente (em log n) de descobrir a posicao de um 
 *   elemento no array e use essa ideia para contar as ocorrencias desse elemento no array
 * 
 * @author campelo
 *
 * @param <T>
 */
public class OccurrencesCounterImpl<T extends Comparable<T>> {

	/*
	 * Se elem está presente no array[], retorna a quantidade de ocorrências de elem.
	 * Caso contrário, retorna 0.
	 */
	public int count(T[] array, T elem) {
		int frequencia = 0;
		return countAux(array, elem, 0, array.length - 1, frequencia);
	}
	/**
	 * Um vez que eu ache o "elem", basta contar ele e seus adjacentes.
	 * 
	 */
	public int countAux(T[] array, T elem, int leftIndex, int rightIndex, int frequencia) {
		int contadorFrequencia = frequencia;
		if(leftIndex <= rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			
			if(elem.compareTo(array[mid]) == 0) {
				contadorFrequencia++;
				if(mid + 1 <= array.length) {
					if(elem.compareTo(array[mid + 1]) == 0) {
						contadorFrequencia += contaIguaisADireita(array, elem, mid); 
					}
				}
				if(mid - 1 >= 0) {
					if(elem.compareTo(array[mid - 1]) == 0) {
						contadorFrequencia += contaIguaisAEsquerda(array, elem, mid);
					}
				}
			}
			
			else if(elem.compareTo(array[mid]) < 0) {
				contadorFrequencia += countAux(array, elem, leftIndex, mid - 1, contadorFrequencia);
			}
			
			else {
				contadorFrequencia += countAux(array, elem, mid + 1, rightIndex, contadorFrequencia);
			}	
			
		}
		
		return contadorFrequencia;
	}
	
	public int contaIguaisADireita(T[] array, T elem, int indice) {
		int frequencia = 0;
		int i = indice;
		while(i + 1 <= array.length) {
			i++;
			if(array[i].compareTo(elem) == 0) {
				frequencia++;
			}
			else {
				break;
			}
		}
		return frequencia;
	}
	
	public int contaIguaisAEsquerda(T[] array, T elem, int indice) {
		int frequencia = 0;
		int i = indice;
		while(i - 1 >= 0) {
			i--;
			if(array[i].compareTo(elem) == 0) {
				frequencia++;
			}
			else {
				break;
			}
		}
		return frequencia;
	}
	
	public static void main(String[] args) {
		OccurrencesCounterImpl c = new OccurrencesCounterImpl();
		Integer[] a1 = {1,2,3,4,5,6,7,8,9,10};
		Integer[] a2 = {1,1,3,4,5,6,7,8,9,10};
		Integer[] a3 = {1,1,1,2,4,6,7,8,9,10};
		
		System.out.println(c.count(a1, 1));
		System.out.println(c.count(a2, 1));
		System.out.println(c.count(a3, 1));

	}

}
