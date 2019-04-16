package ordenacao;

public class BubbleSortInRange {

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex; i < rightIndex; i++) {
			for(int j = leftIndex; j < rightIndex; j++) {
				if(array[j] > array[j + 1]) {
					Util.swap(array, j, j + 1);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		BubbleSortInRange bubble = new BubbleSortInRange();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		 
		bubble.sort(a1, 2, 7);
		bubble.sort(a2, 2, 7);
		bubble.sort(a3, 2, 7);
		bubble.sort(a4, 2, 7);
		
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
