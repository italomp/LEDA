package ordenacao;

public class MergeSort {
	
	public void sort(Integer[] array, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(array, left, mid);
			sort(array, mid +1, right);
			merge(array, left, mid, right);
		}
	}
	
	public void merge(Integer[] array, int left, int mid, int right) {
		int indiceGeral, indiceEsquerda, indiceDireita;
		indiceGeral = left;
		indiceEsquerda = left;
		indiceDireita = mid + 1;
		
		Integer[] aux = new Integer[array.length];
		
		for(int i = 0; i < array.length; i++) {
			aux[i] = array[i];
		}
		
		while(indiceEsquerda <= mid && indiceDireita <= right) {
			if(aux[indiceEsquerda] <= aux[indiceDireita]) {
				array[indiceGeral] = aux[indiceEsquerda];
				indiceGeral++;
				indiceEsquerda++;
			}
			else {
				array[indiceGeral] = aux[indiceDireita];
				indiceGeral++;
				indiceDireita++;
			}
		}
		
		while(indiceEsquerda <= mid) {
			array[indiceGeral] = aux[indiceEsquerda];
			indiceGeral++;
			indiceEsquerda++;
		}
		
		while(indiceDireita <= right) {
			array[indiceGeral] = aux[indiceDireita];
			indiceGeral++;
			indiceDireita++;
		}
	}
	
	public static void main(String[] args) {
		MergeSort merge = new MergeSort();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		 
		merge.sort(a1, 0, a1.length - 1);
		merge.sort(a2, 0, a2.length - 1);
		merge.sort(a3, 0, a3.length - 1);
		merge.sort(a4, 0, a4.length - 1);
		
		for(int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < a3.length; i++) {
			System.out.print(a3[i] + ", ");
		}
		System.out.println();
		
		for(int i = 0; i < a4.length; i++) {
			System.out.print(a4[i] + ", ");
		}
		System.out.println();
	}

}
