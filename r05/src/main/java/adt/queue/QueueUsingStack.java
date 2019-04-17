package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException, StackOverflowException, StackUnderflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		if(isEmpty()) {
			stack1.push(element);
		}
		else {
			if(stack2.isEmpty()) {
				stack1.push(element);
			}
			else {
				while(!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}
				stack1.push(element);
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException, StackUnderflowException, StackOverflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}
		else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			return stack2.top();
		}
	}

	@Override
	public T head() {
		if(!stack2.isEmpty()) {
			return stack2.top();
		}
		else {
			return stack1.head();
		}
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull() || stack2.isFull();
	}

}
