package ordenacao;

public class QuickSort {
	
	public void sort(Integer[] array, int left, int right) {
		if(left < right) {
			int pivot = partition(array, left, right);
			sort(array, left, pivot - 1);
			sort(array, pivot + 1, right);
		}	
	}
	
	public int partition(Integer[] array, int left, int right) {
		int i, posicaoFinalPivot, pivot;
		i = left;
		posicaoFinalPivot = i;
		pivot = array[right];
		
		while(i < right) {
			if(array[i] < pivot) {
				Util.swap(array, i, posicaoFinalPivot);
				posicaoFinalPivot++;
			}
			i++;
		}
		Util.swap(array, posicaoFinalPivot, right);
		return posicaoFinalPivot;
	}
	
	public static void main(String[] args) {
		QuickSort quick = new QuickSort();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		 
		quick.sort(a1, 0, a1.length - 1);
		quick.sort(a2, 0, a2.length - 1);
		quick.sort(a3, 0, a3.length - 1);
		quick.sort(a4, 0, a4.length - 1);
		
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
