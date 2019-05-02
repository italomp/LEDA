package adt.linkedList.extended;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class ListInversionImpl extends SingleLinkedListImpl<Integer> implements ListInversion<Integer> {

	@Override
	public  void reverseIterative() {
		/*  Estratégia: levar o primeiro para o final... segundo para penultima...
		 *	similar o bubble sort.
		 */
		
		for(int i = 0; i < size(); i++) {
			SingleLinkedListNode<Integer> previous = getHead();
			SingleLinkedListNode<Integer> node = getHead().getNext();
			for(int j = 0; j < size(); j++) {
				swap(node, previous);
				node = node.getNext();
				previous = previous.getNext();
			}
		}	
	}
	
	@Override
	public void reverseRecursive() {
		SingleLinkedListNode<Integer> previous = getHead();
		SingleLinkedListNode<Integer> node = getHead().getNext();
		
		reverseRecursive(previous, node);
	}
	
	public void reverseRecursive(SingleLinkedListNode<Integer> previous, 
			SingleLinkedListNode<Integer> node) {
		if(!node.isNIL()) {
			swap(node, previous);
			reverseRecursive(node.getNext(), previous.getNext());
		}
	}
	
	public void swap(SingleLinkedListNode<Integer> node1, SingleLinkedListNode<Integer> node2) {
		Integer temp = node1.getData();
		node1.setData(node2.getData());
		node2.setData(temp);
	}
	

	//NAO ALTERE NADA NESTE METODO. ELE SERA UTIL QUANDO VOCE QUISER TESTAR SUA IMPLEMENTACAO
	@Override
	public void insert(Integer element) {
		SingleLinkedListNode<Integer> auxHead = head;
		if(head.isNIL()){
			SingleLinkedListNode<Integer> newHead = new SingleLinkedListNode<Integer>(element,head);
			head = newHead;
		}else{
			while(!auxHead.getNext().isNIL()){
				auxHead = auxHead.getNext();
			}
			SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(element,auxHead.getNext());
			auxHead.setNext(newNode);
		}
	}

	
}
