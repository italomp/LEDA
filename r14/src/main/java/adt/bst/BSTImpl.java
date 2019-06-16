package adt.bst;

import adt.bt.Util;

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
		return height(this.root);
	}
	
	public int height(BSTNode<T> node) {
		if(node.isEmpty()) {
			return -1;
		}
		else {
			//retorno a maior altura entre left e right
			if(height((BSTNode<T>) node.getLeft()) >= height((BSTNode<T>) node.getRight())) {
				return 1 + height((BSTNode<T>) node.getLeft());
			}
			else {
				return 1 + height((BSTNode<T>) node.getRight());
			}
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.root);
	}

	public BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> aux = new BSTNode();
		if(!node.isEmpty()) {
			if(element.equals(node.getData())) {
				return node;
			}
			else if(element.compareTo((T) node.getData()) < 0) {
				return search(element, (BSTNode<T>) node.getLeft());
			}
			else if(element.compareTo((T) node.getData()) > 0) {
				return search(element, (BSTNode<T>) node.getRight());
			}
		}
		return aux;
	}
	
	@Override
	public void insert(T element) {
		insert(element, this.root, null);
	}
	
	public void insert(T element, BSTNode<T> node, BSTNode parent) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode());
			node.setRight(new BSTNode());
			node.setParent(parent);
		}
		else {
			if(element.compareTo((T) node.getData()) < 0) {
				insert(element, (BSTNode<T>) node.getLeft(), node);
			}
			else {
				insert(element, (BSTNode<T>) node.getRight(), node);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum (this.getRoot());
	}
	
	public BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> aux = node;
		while(!aux.getRight().isEmpty()) {
			aux = (BSTNode<T>) aux.getRight();
		}
		return aux;
	}
	
	@Override
	public BSTNode<T> minimum() {
		return maximum(this.getRoot());
	}
	
	public BSTNode<T> minimum(BSTNode node) {
		BSTNode<T> aux = node;
		while(!aux.getLeft().isEmpty()) {
			aux = (BSTNode<T>) aux.getLeft();
		}
		return aux;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if(node.getRight().isEmpty()) {
			return null;
		}
		else {
			return minimum((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if(node.getLeft().isEmpty()) {
			return null;
		}
		else {
			return maximum((BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public void remove(T element) {
		BSTNode node = search(element);
		remove(element, node);
	}
	
	public void remove(T element, BSTNode<T> node) {
		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
			}
			else if(Util.hasOneChild(node)) {
				//no eh filho da esqueda do pai dele
				if(!node.isRoot()) {
					if(node.getParent().getLeft().getData().equals(node.getData())) {
						//ver se o filho dele eh o filho da direita ou da esquerda
						if(!node.getLeft().isEmpty()) {
							BSTNode<T> parent = (BSTNode<T>) node.getParent();
							BSTNode<T> child = (BSTNode<T>) node.getLeft();
			
							parent.setLeft(child);
							child.setParent(parent);
						}
						else {
							BSTNode<T> parent = (BSTNode<T>) node.getParent();
							BSTNode<T> child = (BSTNode<T>) node.getRight();
			
							parent.setLeft(child);
							child.setParent(parent);
						}
					}
					//no eh filho da direita do pai dele
					else {
						//ver se o filho dele eh o filho da direita ou da esquerda
						if(!node.getLeft().isEmpty()) {
							BSTNode<T> parent = (BSTNode<T>) node.getParent();
							BSTNode<T> child = (BSTNode<T>) node.getLeft();
			
							parent.setRight(child);
							child.setParent(parent);
						}
						else {
							BSTNode<T> parent = (BSTNode<T>) node.getParent();
							BSTNode<T> child = (BSTNode<T>) node.getRight();
			
							parent.setRight(child);
							child.setParent(parent);
						}
					}
		
				}
				//eh root
				else {
					if(!node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getLeft();
						this.root.setParent(null);
					}
					else {
						this.root = (BSTNode<T>) node.getRight();
						this.root.setParent(null);
					}
				}
			}	
			else if(Util.hasTwoChild(node)) {
				BSTNode sucessor = sucessor(element);
				node.setData((T) sucessor.getData());
				remove(element, sucessor);
			}
		}
	}

	@Override
	public T[] preOrder() {
		T[] result = (T[]) new Object[size()];
		int i = -1;
		preOrder(result, this.root, i);
		return result;
	}
	
	public int  preOrder(T[] array, BSTNode node, int i) {
		int index = i;
		if(!node.isEmpty()) {
			index++;
			array[index] = (T) node.getData();
			index = preOrder(array, (BSTNode) node.getLeft(), index);
			index = preOrder(array, (BSTNode) node.getRight(), index);
		}
		return index;
	}

	@Override
	public T[] order() {
		T[] result = (T[]) new Object[size()];
		int i = -1;
		order(result, this.root, i);
		return result;
	}
	
	public int order(T[] array, BSTNode node, int i) {
		int index = i;
		if(!node.isEmpty()) {
			index = order(array, (BSTNode) node.getLeft(), index);
			index++;
			array[index] = (T) node.getData();
			index = order(array, (BSTNode) node.getRight(), index);
		}
		return index;
	}

	@Override
	public T[] postOrder() {
		T[] result = (T[]) new Object[size()];
		int i = -1;
		postOrder(result, this.root, i);
		return result;
	}
	
	public int postOrder(T[] array, BSTNode node, int i) {
		int index = i;
		if(!node.isEmpty()) {
			index = order(array, (BSTNode) node.getLeft(), index);
			index = order(array, (BSTNode) node.getRight(), index);
			index++;
			array[index] = (T) node.getData();
		}
		return index;
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

}
