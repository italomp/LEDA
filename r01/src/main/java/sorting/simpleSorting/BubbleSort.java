package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
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
		for(int i = 0; i <= rightIndex; i++) {
			for(int j = 0; j < rightIndex - i; j++) {
				if(array[j].compareTo(array[j + 1]) > 0) {
					Util.swap(array, j, j + 1);
				}
			}
		}
	}
}
