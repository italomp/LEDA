package ordenacao;

public class SelectionSort {
	public void sort(Integer[] inteiros) {
		for(int i = 0; i < inteiros.length - 1; i++) {
			int menor = i;
			for(int j = i + 1; j < inteiros.length; j++) {
				if(inteiros[j] < inteiros[menor]) {
					menor = j;
				}
			}
			Util.swap(inteiros, i, menor);
		}
	}
	
	public static void main(String[] args) {
		SelectionSort selection = new SelectionSort();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		 
		selection.sort(a1);
		selection.sort(a2);
		selection.sort(a3);
		selection.sort(a4);
		
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
