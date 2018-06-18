package com.deek.list;

public class CircularDoubleLinkedList<T> implements List<T> {
	public static class CircularDoubleNode<T> {
		private T data;
		private CircularDoubleNode<T> previous;
		private CircularDoubleNode<T> next;

		public CircularDoubleNode() {
			data = null;
			previous = null;
			next = null;
		}

		public CircularDoubleNode(T d, CircularDoubleNode p, CircularDoubleNode n) {
			data = d;
			previous = p;
			next = n;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public CircularDoubleNode<T> getPrevious() {
			return previous;
		}

		public void setPrevious(CircularDoubleNode<T> previous) {
			this.previous = previous;
		}

		public CircularDoubleNode<T> getNext() {
			return next;
		}

		public void setNext(CircularDoubleNode<T> next) {
			this.next = next;
		}
	}

	private static int size = 0;
	CircularDoubleNode s = null;

	@Override
	public void addAtEnd(T i) {
		if (s == null) {
			s = new CircularDoubleNode(i, s, s);
			size++;
			return;
		}
		CircularDoubleNode temp = s.getPrevious();
		CircularDoubleNode newnode = new CircularDoubleNode(i, null, null);
		s.setPrevious(newnode);
		newnode.setNext(s);
		temp.setNext(newnode);
		newnode.setPrevious(temp);
		size++;
		return;
	}

	@Override
	public void addAtBegin(T i) {
		if (s == null) {
			s = new CircularDoubleNode(i, s, s);
			size++;
			return;
		}
		CircularDoubleNode newnode = new CircularDoubleNode(i, null, null);
		newnode.setNext(s);
		CircularDoubleNode temp = s.getPrevious();
		s.setPrevious(newnode);
		newnode.setPrevious(temp);
		temp.setNext(newnode);
		s = newnode;
		size++;
		return;
	}

	@Override
	public void addAtPosition(int i, T p) {
		if (i <= 0 || i > size + 1)
			return;
		if (i == 1) {
			addAtBegin(p);
			return;
		}
		if (i == size + 1) {
			addAtEnd(p);
			return;
		}
		int count = 0;
		CircularDoubleNode temp = s;
		while (temp.getNext() != s) {
			count++;
			if (count == i - 1) {
				CircularDoubleNode temp2 = temp.getNext();
				CircularDoubleNode newnode = new CircularDoubleNode(p, null, null);
				temp2.setPrevious(newnode);
				newnode.setNext(temp2);
				temp.setNext(newnode);
				newnode.setPrevious(temp);
			}
			temp = temp.getNext();
		}
		size++;
		return;
	}

	@Override
	public void deleteAtPosition(int i) {
		if (s == null || i <= 0 || i > size)
			return;
		CircularDoubleNode temp = s;
		int count = 0;
		while (temp.getNext() != s) {
			count++;
			if (count == i - 1) {
				CircularDoubleNode temp2 = temp.getNext();
				temp2 = temp2.getNext();
				temp.setNext(temp2);
				temp2.setPrevious(temp);
			}
			temp = temp.getNext();
		}
		size--;
		return;
	}

	@Override
	public void deleteAtEnd() {
		deleteAtPosition(size);
		return;
	}

	@Override
	public void deleteAtBegin() {
		deleteAtPosition(1);
		return;
	}

	@Override
	public void print() {
		if (s == null)
			return;
		CircularDoubleNode temp = s;
		while (temp.getNext() != s) {
			System.out.print(temp.getData() + " ,");
			temp = temp.getNext();
		}
		return;
	}

	@Override
	public T getElementAt(int i) {
		if (i <= 0 || i > size)
			return null;
		int count = 0;
		CircularDoubleNode temp = s;
		while (temp.getNext() != s) {
			count++;
			if (count == i - 1) {
				break;
			}
			temp = temp.getNext();
		}
		temp = temp.getNext();
		return (T) temp.getData();
	}

	@Override
	public T getFirstElement() {
		if (s == null)
			return null;
		return (T) s.getData();
	}

	@Override
	public T getLastElement() {
		// TODO Auto-generated method stub
		return (T) s.getPrevious().getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(T i) {
		int flag = 0;
		int count = 0;
		CircularDoubleNode temp = s;
		int position = 0;
		while (temp.getNext() != s) {
			count++;
			if (temp.getData() == i) {
				position = count;
				flag = 1;
				break;
			}
			temp = temp.getNext();
		}
		if (flag == 1)
			return position;
		else
			return -1;
	}

}
