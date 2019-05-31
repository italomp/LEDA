package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import util.Util;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}

	@Override
	public T[] sort(T[] array) {
		BSTImpl<T> bst = new BSTImpl<>();
		T[] result;
		for(int i = 0; i < array.length; i++) {
			bst.insert(array[i]);
		}
		result = bst.order();
		return result;
	}

	@Override
	public T[] reverseOrder() {
		T[] result = (T[]) new Integer[this.size()];
		ArrayList<T> list = new ArrayList<>();
		reverseOrder(list, this.root);
		Util.converterListaEmArray(list, result);
		return result;
	}
	
	public void reverseOrder(ArrayList<T> list, BSTNode<T> node) {
		if(!node.isEmpty()) {
			reverseOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
			reverseOrder(list, (BSTNode<T>) node.getLeft());
		}
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	
}
