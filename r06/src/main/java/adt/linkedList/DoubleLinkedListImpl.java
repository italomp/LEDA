package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxPrevious = ((DoubleLinkedListNode<T>) getHead()).getPrevious();
		
		auxPrevious.setData(element);
		auxPrevious.setPrevious(new DoubleLinkedListNode());
		auxPrevious.setNext(auxHead);
		setHead(auxPrevious);
	}

	@Override
	public void removeFirst() {
		if(!getHead().isNIL()) {
			this.head = (DoubleLinkedListNode<T>) getHead().getNext();
			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode());
		}
		if(getHead().isNIL()) {
			setLast((DoubleLinkedListNode<T>) getHead());
		}
	}

	@Override
	public void removeLast() {
		if(!getHead().isNIL()) {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
			DoubleLinkedListNode<T> newLast;
			while(!aux.getNext().isNIL()) {
				aux = aux.getNext();
			}
			newLast = aux.getPrevious();
			newLast.setNext(new DoubleLinkedListNode());
			setLast(newLast);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
	
	@Override
	public void insert(T element) {
		if(getHead().isNIL()){
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode(element,
					new DoubleLinkedListNode(), new DoubleLinkedListNode());
			setHead(newNode);
			setLast(newNode);
		}
		else{
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
			DoubleLinkedListNode<T> previous = (DoubleLinkedListNode<T>) this.head;
			while(!aux.isNIL()) {
				previous = aux;
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
			aux.setData(element);
			aux.setNext(new DoubleLinkedListNode());
			aux.setPrevious(previous);
			setLast(aux);
		}
	}
	
	@Override
	public void remove(T element) {
		if(getHead().getData().equals(element)) {
			setHead(getHead().getNext());
			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode());
		}
		else {
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
			DoubleLinkedListNode<T> previous = aux;
			DoubleLinkedListNode<T> next;
			while(!aux.isNIL() && !aux.getData().equals(element)) {
				previous = aux;
				aux = (DoubleLinkedListNode<T>) aux.getNext();
			}
			if(aux.getData().equals(element)) {
				next =  (DoubleLinkedListNode<T>) aux.getNext();
				previous.setNext(next);
				next.setPrevious(previous);
				if(next.isNIL()) {
					setLast(previous);
				}
				else {
					setLast(next);
				}
			}
		}
	}
	
	@Override
	public T search(T element) {
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) getHead();
		DoubleLinkedListNode<T> auxLast =  getLast();
		T retorno = null;
		
		for(int i = 0; i < size() / 2; i ++) {
			if(auxHead.getData().equals(element)) {
				retorno = auxHead.getData();
			}
			else if (auxLast.getData().equals(element)) {
				retorno = auxLast.getData();
			}
			else {
				auxHead =  auxHead.getNext();
				auxLast =  auxLast.getPrevious();
			}
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		DoubleLinkedListImpl<Integer> d = new DoubleLinkedListImpl();
		
		System.out.println("TESTANDO ADICIONAR");
		d.insert(10);
		d.insert(9);
		d.insert(8);
		d.insert(7);
		d.insert(6);
		d.insert(5);
		d.insert(4);
		d.insert(3);
		d.insert(2);
		d.insert(1);
		
		Object[] a1 = d.toArray();
		
		for(Object obj : a1) {
			System.out.print(obj + " ");
		}
		System.out.println();
		System.out.println("tamanho aqui e: " + d.size());
		
		System.out.println("TESTANDO GETLAST");
		System.out.println("Last é: " + d.getLast().getData());
		
		System.out.println("TESTANDO REMOVER");
		d.remove(10);
		d.remove(5);
		d.remove(1);
		
		Object[] a2 = d.toArray();
		
		for(Object obj : a2) {
			System.out.print(obj + " ");
		}
		System.out.println();
		System.out.println("tamanho aqui e: " + d.size());
		System.out.println("TESTANDO GETLAST");
		System.out.println("Last é: " + d.getLast().getData());
		
		System.out.println("TESTANDO SEARCH");
		System.out.println("Search 9: " + d.search(9));
		System.out.println("Search 4: " + d.search(4));
		System.out.println("Search 2: " + d.search(2));
		System.out.println("Search 1: " + d.search(1));
				
		System.out.println("TESTANDO INSERTFIRST");
		d.insertFirst(34);
		d.insertFirst(36);
		d.insertFirst(35);
		
		Object[] a3 = d.toArray();
		
		for(Object obj : a3) {
			System.out.print(obj + " ");
		}
		System.out.println();
		
		System.out.println("head é: " + d.getHead());
		System.out.println("size é: " + d.size());
		System.out.println("last é: " + d.getLast());
		
		System.out.println("TESTANDO REMOVEFIRST");
		d.removeFirst();
		d.removeFirst();
		d.removeFirst();
		
		Object[] a4 = d.toArray();
		
		for(Object obj : a4) {
			System.out.print(obj + " ");
		}
		System.out.println();
		
		System.out.println("head é: " + d.getHead());
		System.out.println("size é: " + d.size());
		System.out.println("last é: " + d.getLast());
		
		System.out.println("TESTANDO LAST");
		d.removeLast();
		d.removeLast();
		d.removeLast();
		
		Object[] a5 = d.toArray();
		
		for(Object obj : a5) {
			System.out.print(obj + " ");
		}
		System.out.println();
		
		System.out.println("head é: " + d.getHead());
		System.out.println("size é: " + d.size());
		System.out.println("last é: " + d.getLast());
		
	}

}
