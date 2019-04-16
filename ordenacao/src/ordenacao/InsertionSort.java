package ordenacao;

public class InsertionSort {
	
	public void sort(Integer[] inteiros) {
		for(int i = 1; i < inteiros.length; i++) {
			int j = i;
			while(j > 0) {
				if(inteiros[j] < inteiros[j -1]) {
					Util.swap(inteiros, j, j -1);
				}
				j--;
				
			}
		}
	}

	public static void main(String[] args) {
		InsertionSort insertion = new InsertionSort();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		 
		insertion.sort(a1);
		insertion.sort(a2);
		insertion.sort(a3);
		insertion.sort(a4);
		
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
