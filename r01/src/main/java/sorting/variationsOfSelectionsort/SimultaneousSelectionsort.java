package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.equals(null)) {
			return;
		}
		else if(leftIndex < 0) {
			leftIndex = 0;
		}
		else if (rightIndex > array.length - 1) {
			rightIndex = array.length - 1;
		}
		else if(leftIndex > rightIndex) {
			return;
		}
		for(int i = leftIndex; i <= rightIndex / 2; i++) {
			int menor = i;
			int maior = rightIndex - i;
			for(int j = i; j <= rightIndex - i; j++) {
				if(array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
				if(array[j].compareTo(array[maior]) > 0) {
					maior = j;
				}
			}
			//quando o array está ordenado do maior para o menor
			// eu troco i com menor, depois DESTROCO como o seguinte swap
			if(maior != i && menor != (rightIndex - i)) {
				Util.swap(array, i, menor);              // <------ troco
				Util.swap(array, maior, rightIndex - i); // <------ destroco
			}
			else {
				Util.swap(array, i, menor);              // <------ troco
			}
			
		}
	}
}

