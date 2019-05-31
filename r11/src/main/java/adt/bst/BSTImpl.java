package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;
import util.Util;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(getRoot());
	}
	
	public int height(BSTNode<T> node) {
		if(node.isEmpty()) {
			return -1;
		}
		else {
			BSTNode<T> left = (BSTNode<T>) node.getLeft();
			BSTNode<T> right = (BSTNode<T>) node.getRight();
			if(height(left) >= height(right)) {
				return height(left) + 1;
			}
			else {
				return height(right) + 1;
			}
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, getRoot());
	}
	
	public BSTNode<T> search(T element, BSTNode<T> node) {
		if(!node.isEmpty()) {
			if(element.compareTo(node.getData()) == 0) {
				return node;
			}
			else if(element.compareTo(node.getData()) < 0) {
				return search(element, (BSTNode<T>) node.getLeft());
			}
			else {
				return search(element, (BSTNode<T>) node.getRight());
			}
		}
		return  new BSTNode<>();
	}

	@Override
	public void insert(T element) {
		insert(element, this.root, null);
	}
	
	public void insert(T element, BSTNode<T> node, BSTNode<T> parent) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(parent);
		}
		else {
			if(element.compareTo(node.getData()) < 0) {
				insert(element, (BSTNode<T>) node.getLeft(), node);
			}
			else {
				insert(element, (BSTNode<T>) node.getRight(), node);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(getRoot());
	}
	
	public BSTNode<T> maximum(BSTNode<T> node) {
		if(node.isEmpty()) {
			return null;
		}
		while(!node.getRight().isEmpty()) {
			node = (BSTNode<T>) node.getRight();
		}
		return node;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(getRoot());
	}
	
	public BSTNode<T> minimum(BSTNode<T> node) {
		if(node.isEmpty()) {
			return null;
		}
		while(!node.getLeft().isEmpty()) {
			node = (BSTNode<T>) node.getLeft();
		}
		return node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if(node.isEmpty()) {
			return null;
		}
		else {
			if(node.getRight().isEmpty()) {
				return null;
			}
			return minimum((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if(node.isEmpty()) {
			return null;
		}
		else {
			if(node.getLeft().isEmpty()) {
				return null;
			}
			return maximum((BSTNode<T>) node.getLeft());
		}			
	}
	
	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(element, node);
	}

	public void remove(T element, BSTNode<T> node) {
		if(node.equals(null)) {
			return;
		}
		if(node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		}
		else if(node.hasOneChild()) {
			if(!node.isRoot()) {
				BTNode<T> parent = node.getParent();
				BSTNode<T> child;
				if(node.isLeftChild()) {
					if(!node.getLeft().isEmpty()) {
						child = (BSTNode<T>) node.getLeft();
						child.setParent(parent);
						parent.setLeft(child);
					}
					else {
						child = (BSTNode<T>) node.getRight();
						child.setParent(parent);
						parent.setLeft(child);
					}
				}
				else {
					if(!node.getLeft().isEmpty()) {
						child = (BSTNode<T>) node.getLeft();
						child.setParent(parent);
						parent.setRight(child);
					}
					else {
						child = (BSTNode<T>) node.getRight();
						child.setParent(parent);
						parent.setRight(child);
					}	
				}
			}
			else {
				if(node.hasTwoChild()) {
					BSTNode<T> sucessor = sucessor(node.getData());
					node.setData(sucessor.getData());
					remove(element, sucessor);
				}
				else if(node.hasOneChild()) {
					if(!node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getLeft(); 
					}
					else {
						this.root = (BSTNode<T>) node.getRight();
					}
				}
			}
		}
		else if(node.hasTwoChild()) {
			BSTNode<T> sucessor = sucessor(node.getData());
			node.setData(sucessor.getData());
			remove(element, sucessor);
		}
	}
	
	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		T[] result = (T[]) new Integer[size()];
		preOrder(this.root, list);
		Util.converterListaEmArray(list, result);
		return result;
	}

	public void preOrder(BSTNode<T> node, ArrayList<T> list) {
		if(!node.isEmpty()) {
			list.add(node.getData());
			preOrder((BSTNode<T>) node.getLeft(), list);
			preOrder((BSTNode<T>) node.getRight(), list);
		}
	}
	
	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		T[] result = (T[]) new Integer[size()];
		order(this.root, list);
		Util.converterListaEmArray(list, result);
		return result;
	}
	
	public void order(BSTNode<T> node, ArrayList list) {
		if(!node.isEmpty()) {
			order((BSTNode) node.getLeft(), list);
			list.add(node.getData());
			order((BSTNode) node.getRight(), list);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		T[] result = (T[]) new Integer[size()];
		postOrder(this.root, list);
		Util.converterListaEmArray(list, result);
		return result;
	}
	
	public void postOrder(BSTNode<T> node, ArrayList list) {
		if(!node.isEmpty()) {
			postOrder((BSTNode) node.getLeft(), list);
			postOrder((BSTNode) node.getRight(), list);
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}
	
	public static void main(String[] args) {
		BST<Integer> bst = new BSTImpl<>();
		Integer[] array;
		
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		
		array = bst.preOrder();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		array = bst.order();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		array = bst.postOrder();
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		System.out.println(bst.getRoot().getData());
		System.out.println(bst.getRoot().getLeft().getData());
		System.out.println(bst.getRoot().getRight().getData());
		System.out.println("search 5: " + bst.search(5));
		System.out.println("search 3: " + bst.search(3));
		System.out.println("search 7: " + bst.search(7));
		System.out.println("minimum:" + bst.minimum());
		System.out.println("maximum: " + bst.maximum());
		System.out.println("sucessor do 5: " + bst.sucessor(5));
		System.out.println("predecessor do 5: " + bst.predecessor(5));
		System.out.println("sucessor do 3: " + bst.sucessor(3));
		System.out.println("predecessor do 3: " + bst.predecessor(3));
		System.out.println("altura1 bst = 1 ==> " + bst.height());
		bst.insert(2);
		System.out.println("altura1 bst = 2 ==> " + bst.height());
		bst.insert(1);
		System.out.println("altura1 bst = 3 ==> " + bst.height());
		bst.remove(5);
		System.out.println("search 5 => " + bst.search(5).getData());
		System.out.println("search 3 => " + bst.search(3).getData());
		System.out.println("search 7 => " + bst.search(7).getData());
		System.out.println("search 2 => " + bst.search(2).getData());
		System.out.println("search 1 => " + bst.search(1).getData());
		bst.remove(1);
		System.out.println("search 1 => " + bst.search(1).getData());
		bst.remove(3);
		System.out.println("search 3 => " + bst.search(3).getData());
	}

}
