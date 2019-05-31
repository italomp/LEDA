package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode aux = this.head;
		
		while(!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL() && !aux.getData().equals(element)) {
			aux = aux.getNext();
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()) {
			aux = aux.getNext();
		}
		aux.setData(element);
		aux.setNext(new SingleLinkedListNode());
	}

	@Override
	public void remove(T element) {
		if(this.getHead().getData().equals(element)) {
			this.head = this.head.getNext();
		}
		else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = this.head;
			while(!aux.isNIL() && !aux.getData().equals(element)) {
				previous = aux;
				aux = aux.getNext();
			}
			if(aux.getData().equals(element)) {
				previous.setNext(aux.getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()]; 
		SingleLinkedListNode<T> aux = this.head;
		int i = 0;
		while(!aux.isNIL()) {
			array[i] = aux.getData();
			aux = aux.getNext();
			i++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}
	


}
