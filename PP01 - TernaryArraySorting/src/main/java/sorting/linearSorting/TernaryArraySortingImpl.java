package sorting.linearSorting;

import util.Util;

public class TernaryArraySortingImpl<T extends Comparable<T>> implements TernaryArraySorting<T>{
	
	public void sort(T[] ternaryArray) {		
		T menor = buscaMenor(ternaryArray);
		T maior = buscaMaior(ternaryArray);
		
		int posicaoMenor = 0;
		for(int i = 0; i < ternaryArray.length; i++) {
			if(ternaryArray[i].compareTo(menor) == 0) {
				Util.swap(ternaryArray, posicaoMenor, i);
				posicaoMenor++;
			}
		}
		
		int posicaoMaior = ternaryArray.length -1;
		for(int i = ternaryArray.length - 1; i >= 0; i--) {
			if(ternaryArray[i].compareTo(maior) == 0) {
				Util.swap(ternaryArray, posicaoMaior, i);
				posicaoMaior--;
			}
		}
	}
	
	public T buscaMenor(T[] array) {
		T menor = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
		}
		return menor;
	}
	
	public T buscaMaior(T[] array) {
		T maior = array[0];
		for(int i = 0; i < array.length; i++) {
			if(array[i].compareTo(maior) > 0) {
				maior = array[i];
			}
		}
		return maior;
	}
	
	public static void main(String[] args) {
		TernaryArraySortingImpl t = new TernaryArraySortingImpl();
		
		Integer[] a1 = {0,0,0,1,1,1,3,3,3};
		Integer[] a2 = {3,3,3,1,1,1,0,0,0};
		Integer[] a3 = {3,1,0,3,1,0,3,1,0};
		Integer[] a4 = {3,3,3,3,3,0,1,1,1};
		
		t.sort(a1);
		t.sort(a2);
		t.sort(a3);
		t.sort(a4);
		
		for(int i = 0; i < a1.length; i++) {
			System.out.print(a1[i]);
		}
		System.out.println();
		
		for(int i = 0; i < a2.length; i++) {
			System.out.print(a2[i]);
		}
		System.out.println();
		
		for(int i = 0; i < a3.length; i++) {
			System.out.print(a3[i]);
		}
		System.out.println();
		
		for(int i = 0; i < a4.length; i++) {
			System.out.print(a4[i]);
		}
		
	}
	
	
}
