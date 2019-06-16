package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		return height((BSTNode<T>) node.getLeft()) - 
				height((BSTNode<T>) node.getRight());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		if(!node.isEmpty()) {
			//RR
			if(calculateBalance(node) < -1 && 
					calculateBalance((BSTNode<T>) node.getRight()) < -1) {
				Util.leftRotation(node);
			}
			//LL
			else if(calculateBalance(node) > 1 &&
					calculateBalance((BSTNode<T>) node.getLeft()) > 1) {
				Util.rightRotation(node);
			}
			//RL
			else if(calculateBalance(node) < -1 &&
					calculateBalance((BSTNode<T>) node.getRight()) > 1) {
				Util.rightRotation((BSTNode<T>) node.getRight());
				Util.leftRotation(node);
				
			}
			//LR
			else if(calculateBalance(node) > 1 &&
					calculateBalance((BSTNode<T>) node.getLeft()) < -1) {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				Util.rightRotation(node);
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		if(node != null) {
			rebalance(node);
			rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
	
	@Override
	public void insert(T element) {
		insert(element, this.root, null);
	}
	
	@Override
	public void insert(T element, BSTNode<T> node, BSTNode parent) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode());
			node.setRight(new BSTNode());
			node.setParent(parent);
			rebalanceUp(node);
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
	public void remove(T element) {
		BSTNode node = search(element);
		remove(element, node);
	}
	
	@Override
	public void remove(T element, BSTNode<T> node) {
		if(!node.isEmpty()) {
			if(node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
				//se eu usar rebalande num noh com left e right nulos, vai dar null pointer.
				//Pois vou chegar a usa calculateBalance: null - int = NullPointerException
				rebalanceUp((BSTNode<T>) node.getParent());
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
					rebalanceUp((BSTNode<T>) node.getParent());
				}
				//eh root
				//Se o noh eh root e so tem um filho, esse no esta balanceado, pois eu garanto isso na insercao,
				//e nao preciso aplicar rebalance nele.
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
	
}
