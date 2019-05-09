package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		int size = 0;
		if(isEmpty()) {
			return size;
		}
		else {
			size++;
			size += this.next.size();
			return size;
		}
	}
	
	@Override
	public T search(T element) {
		if(isEmpty()) {
			return null;
		}
		else {
			if(this.data.equals(element)) {
				return getData();
			}
			else {
				return this.next.search(element);
			}
		}
	}

	@Override
	public void insert(T element) {
		if(element.equals(null)) {
			return;
		}
		else {
			if(isEmpty()) {
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<T>());
			}
			else {
				this.next.insert(element);
			}
		}
	}
	
	@Override
	public void remove(T element) {
		if(isEmpty()) {
			return;
		}
		else {
			if(getData().equals(element)) {
				setData(getNext().getData());
				setNext(getNext().getNext());
			}
			else {
				this.next.remove(element);
			}
		}
	}
	
	@Override
	public T[] toArray() {	
		T[] retorno = (T[]) new Object[size()];
		int index = 0;
		if(isEmpty()) {
			return retorno;
		}
		else {
			retorno[index] = getData();
			toArray(retorno, index + 1, getNext());
		}
		return retorno;
	}
	
	public void toArray(T[] retorno, int i, RecursiveSingleLinkedListImpl<T> node) {	
		int index = i;
		if(!node.isEmpty()) {
			retorno[index] = node.getData();
			toArray(retorno, index + 1, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}
	
//	public static void main(String[] args) {
//		System.out.println("chegou aqui");
//		RecursiveSingleLinkedListImpl<Integer> l = new RecursiveSingleLinkedListImpl<>();
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
//		System.out.println("inseri");
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
