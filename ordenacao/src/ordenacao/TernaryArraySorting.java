package ordenacao;


public class TernaryArraySorting{
	
	public void sort(Integer[] ternaryArray) {		
		int smaller = searchSmaller(ternaryArray);
		int bigger = searchBigger(ternaryArray);
		int posicaoMenor = 0;
		int posicaoMaior = ternaryArray.length -1;
		
		//deixando os menores no comeco
		for(int i = 0; i < ternaryArray.length; i++) {
			if(ternaryArray[i] == smaller) {
				swap(ternaryArray, i, posicaoMenor);
				posicaoMenor++;
			}
		}	
		//uma vez que os menores estejam no comeco, basta levar
		//os maiores pro final, pois soh tenho 3 tipos de elementos,
		//os menores estao no inicio, os maiores no final, logo os medianos
		//ficarao no meio e assim o array estara ordenado
		for(int i = ternaryArray.length - 1; i >= 0; i--) {
			if(ternaryArray[i] == bigger) {
				swap(ternaryArray, i, posicaoMaior);
				posicaoMaior--;
			}
		}	
	}
	
	public int searchSmaller(Integer[] array) {
		int smaller = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i].compareTo(smaller) < 0) {
				smaller = array[i];
			}
		}
		return smaller;
	}
	
	public int searchBigger(Integer[] array) {
		int bigger = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i].compareTo(bigger) > 0) {
				bigger = array[i];
			}
		}
		return bigger;
	}
	
	public void swap(Integer[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		TernaryArraySorting ternary = new TernaryArraySorting();
		
		Integer[] a1 = {3,2,3,2,3,2,1,2,1,2};
		Integer[] a2 = {3,3,3,3,2,2,2,1,1,1};
		Integer[] a3 = {3,2,3,1,3,2,3,1,3,2,3};
		 
		ternary.sort(a1);
		ternary.sort(a2);
		ternary.sort(a3);

		
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
	}
	
}
