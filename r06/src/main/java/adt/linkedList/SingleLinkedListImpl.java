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
	
//	public static void main(String[] args) {
//		SingleLinkedListImpl<Integer> l = new SingleLinkedListImpl<>();
//		
//		l.insert(1);
//		l.insert(2);
//		l.insert(3);
//		l.insert(4);
//		l.insert(5);
//		l.insert(6);
//		l.insert(7);
//		l.insert(8);
//		l.insert(9);
//		l.insert(10);
//		
//		Object[] a1 = l.toArray();
//		for(Object i : a1) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		System.out.println("search: 1 ->" + l.search(1));
//		System.out.println("search: 10 ->" + l.search(10));
//		System.out.println("search: 5 ->" + l.search(5));
//		System.out.println("size: 10 -> " + l.size());
//		
//		l.remove(1);
//		l.remove(5);
//		l.remove(10);
//		
//		System.out.println("search: 1 ->" + l.search(1));
//		System.out.println("search: 10 ->" + l.search(10));
//		System.out.println("search: 5 ->" + l.search(5));
//		System.out.println("size: 10 -> " + l.size());
//	
//		Object[] a2 = l.toArray();
//		for(Object i : a2) {
//			System.out.print(i + " ");
//		}
//	}

}
