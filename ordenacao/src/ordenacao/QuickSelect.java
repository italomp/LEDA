package ordenacao;
/**
 * Solução para selecionar o k-ésimo menor elemento 
 * 
 * @author Italo Modesto
 *
 */
public class QuickSelect {
	public int quickSelect(Integer[] array, int leftIndex, int rightIndex, int k){
		
//		if(leftIndex < 0) {
//			leftIndex = 0;
//		}
//		else if(rightIndex > array.length - 1) {
//			rightIndex = array.length - 1;
//		}
//		
//		
//		Se eu estivesse trabalhando com objetos eu poderia usar esse treco:
//		
//		else if(k > rightIndex) {
//			return;
//		}
//		else if(leftIndex > rightIndex) {
//			return;
//		}
//		mas como o retorno tem que ser do tipo int, não posso retornar null;
		
		
		if(leftIndex < rightIndex) {
			int pivot = particiona(array, leftIndex, rightIndex);
			if((k - 1) == pivot) {
				return array[pivot];
			}
			else if((k - 1 ) < pivot) {
				return quickSelect(array, leftIndex, pivot - 1, k);
			}
			else {
				return quickSelect(array, pivot + 1, rightIndex, k);
			}
		}
		else {
			return 0;
		}
	}
	
	public int particiona(Integer[] array, int leftIndex, int rightIndex) {
		int pivot = array[rightIndex];
		int posicaoPivot = leftIndex;
		
		for(int i = 0; i < rightIndex; i++) {
			if(array[i] <= pivot) {
				swap(array, i, posicaoPivot);
				posicaoPivot++;
			}
		}
		swap(array, rightIndex, posicaoPivot);
		return posicaoPivot;
	}
	
	public void swap(Integer array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) throws Exception {
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		QuickSelect qs = new QuickSelect();
		
		System.out.println(qs.quickSelect(a1, 0, 9, 1));
		System.out.println(qs.quickSelect(a1, 0, 9, 5));
		System.out.println(qs.quickSelect(a1, 0, 9, 10));
	}
	
	
}
