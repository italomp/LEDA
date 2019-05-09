package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;
	protected RecursiveDoubleLinkedListImpl<T> last;

	public RecursiveDoubleLinkedListImpl() {
	
	}
	
	public RecursiveDoubleLinkedListImpl(T element, RecursiveDoubleLinkedListImpl<T> pervious,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = element;
		this.previous = previous;
		this.next = next;	
	}

	@Override
	public void insertFirst(T element) {
		RecursiveDoubleLinkedListImpl<T> antigoPrimeiro = 
				new RecursiveDoubleLinkedListImpl<>(this.data, this, this.next);
		setData(element);
		setNext(antigoPrimeiro);
		setPrevious(new RecursiveDoubleLinkedListImpl<>());
		
	}

	@Override
	public void removeFirst() {
		if(this.next.equals(null)) {
			setData(null);
		}
		else {
			setData(getNext().getData());
			setNext(getNext().getNext());
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(this.next.isEmpty()) {
				this.data = null;
			}
			else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}
	

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
	
	@Override
	public void insert(T element) {
		if(element == null) {
			return;
		}
		if(isEmpty()) {
			setData(element);
			setNext(new RecursiveDoubleLinkedListImpl<>());
			setPrevious(new RecursiveDoubleLinkedListImpl<>());
			last = this;
		}
		else if(this.next.isEmpty()) {
			this.next.setData(element);
			this.next.setNext(new RecursiveDoubleLinkedListImpl<>());
			((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
			last = (RecursiveDoubleLinkedListImpl<T>) this.next;
		}
		else {
			this.next.insert(element);
		}
	}
	
	@Override
	public void remove(T element) {
		if(element == null) {
			return;
		}
		if(!isEmpty()) {
			if(this.data == element) {	
				if(!this.next.equals(null)) {
					setData(getNext().getData());
					setNext(getNext().getNext());
				}
				else {
					this.data = null;
				}
			}
			else {
				if(!this.next.equals(null)) {
					this.next.remove(element);
				}
			}	
		}
		
	}

//	public static void main(String[] args) {
//		RecursiveDoubleLinkedListImpl<Integer> l = new RecursiveDoubleLinkedListImpl<>();
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
//		System.out.println("Testando previous");
//		Object[] aa1 = l.toArray();
//		for(int i = aa1.length - 1; i >= 0; i--) {
//			System.out.print(aa1[i] + " ");
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
//		System.out.println();
//		
//		System.out.println("Testando previous");
//		Object[] aa2 = l.toArray();
//		for(int i = aa2.length - 1; i >= 0; i--) {
//			System.out.print(aa2[i] + " ");
//		}
//		System.out.println();
//		
//		System.out.println("Testando insertFirst");
//		l.insertFirst(98);
//		l.insertFirst(97);
//		l.insertFirst(100);
//		
//		Object[] a3 = l.toArray();
//		for(Object i : a3) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		System.out.println("Testando removeFirst");
//		l.removeFirst();
//		l.removeFirst();
//		l.removeFirst();
//		
//		Object[] a4 = l.toArray();
//		for(Object i : a4) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		System.out.println("Testando removeLast");
//		l.removeLast();
//		l.removeLast();
//		l.removeLast();
//		
//		Object[] a5 = l.toArray();
//		for(Object i : a5) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println("size: 10 -> " + l.size());
//	}
}
