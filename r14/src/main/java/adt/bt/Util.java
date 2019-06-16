package adt.bt;

import adt.bst.BSTNode;

public class Util {
	

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		//ROTACAO QUE MANTEM A RELACAO ENTRE O PAI DO NO E SUAS SUB-ARVORES
		//obs: se seguir apenas o algoritmo do slide, sub-arvores perdem relacao com o pai.
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		node.setRight(pivot.getLeft());
		pivot.setLeft(node);
		node.setParent(pivot);
		node = pivot;	
		
		node.setParent(parent);
		if(parent != null) {
			if(node.equals((BSTNode<T>) parent.getLeft())) {
				parent.setLeft(node);
			}
			else if(node.equals((BSTNode<T>) parent.getRight())) {
				parent.setRight(node);
			}
		}
		return node;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		//ROTACAO QUE MANTEM A RELACAO ENTRE O PAI DO NO E SUAS SUB-ARVORES
		//obs: se seguir apenas o algoritmo do slide, sub-arvores perdem relacao com o pai.
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();
		node.setLeft(pivot.getRight());
		pivot.setRight(node);
		node.setParent(pivot);
		node = pivot;
		
		node.setParent(parent);
		if(parent != null) {
			if(node.equals((BSTNode<T>) parent.getLeft())) {
				parent.setLeft(node);
			}
			else if(node.equals((BSTNode<T>) parent.getRight())) {
				parent.setRight(node);
			}
		}
		return node;
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
	
	public static boolean hasOneChild(BSTNode node) {
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) ||
				(!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}
	
	public static boolean hasTwoChild(BSTNode node) {
		return !(node.getLeft().isEmpty() || node.getRight().isEmpty());
	}
	
}
