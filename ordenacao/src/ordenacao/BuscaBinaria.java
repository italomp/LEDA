package ordenacao;

public class BuscaBinaria {
	
	public int buscaBinaria(Integer[] array, int leftIndex, int rightIndex, int elemento) {
		if(leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			
			if(elemento == array[mid]) {
				return array[mid];
			}
			else if(elemento < array[mid]) {
				return buscaBinaria(array, leftIndex, mid -1, elemento);
			}
			else {
				return buscaBinaria(array, mid + 1, rightIndex, elemento);
			}
		}
		else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		BuscaBinaria bb = new BuscaBinaria();
		
		Integer[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Integer[] a2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		Integer[] a3 = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
		Integer[] a4 = {5, 4, 3, 2, 1, 10, 9, 8, 7, 6};
		 
		System.out.println(bb.buscaBinaria(a1, 0, 9, 8));
		System.out.println(bb.buscaBinaria(a1, 0, 9, 2));
		System.out.println(bb.buscaBinaria(a1, 0, 9, 24));
	}
}
