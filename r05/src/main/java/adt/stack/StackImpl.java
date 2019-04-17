package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if(!isEmpty()) {
			return this.array[top];
		}
		else {
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.array.length - 1 == top;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
			top++;
			this.array[top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			top--;
			return this.array[top + 1];
		}
	}
	
	public T head() {
		if(isEmpty()) {
			return null;
		}
		else {
			return this.array[0];
		}
		
	}

}
