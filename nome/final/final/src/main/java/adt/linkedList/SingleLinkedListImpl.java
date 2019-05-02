package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		return size(getHead());
	}
	
	public int size(SingleLinkedListNode<T> node) {
		int size = 0;
		while(!node.isNIL()) {
			size++;
			node = node.getNext();
		}	
		return size;
	}

	@Override
	public T search(T element) {
		return search(getHead(), element);
	}
	
	public T search(SingleLinkedListNode<T> node, T element) {
		T result = null;
		if(node.isNIL()) {
			return null;
		}
		else {
			while(!node.isNIL()) {
				if(node.getData().equals(element)) {
					result = node.getData();
					return result;
				}
				else {
					node = node.getNext();
				}
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(!element.equals(null)) {
			SingleLinkedListNode<T> node = getHead();
			while(!node.isNIL()) {
					node = node.getNext();
			}
			node.setData(element);
			node.setNext(new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if(element.equals(null)) {
			SingleLinkedListNode<T> node = getHead();
			while(!node.isNIL() && !node.getData().equals(element)) {
				node = node.getNext();
			}
			node.setData(node.getNext().getData());
			node.setNext(node.getNext().getNext());	
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> node = getHead();
		int index = 0;
		while(!node.isNIL()) {
			array[index] = node.getData();
			index++;
			node = node.getNext();
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
