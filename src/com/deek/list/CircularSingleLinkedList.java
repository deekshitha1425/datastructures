package com.deek.list;

public class CircularSingleLinkedList<T> implements List<T> {
	public static class CircularSingleNode<T> {
		private T data;
		private CircularSingleNode<T> next;

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public CircularSingleNode getNext() {
			return next;
		}

		public void setNext(CircularSingleNode next) {
			this.next = next;
		}

		public CircularSingleNode() {
			data = null;
			next = null;
		}

		public CircularSingleNode(T d, CircularSingleNode c) {
			data = d;
			next = c;
		}
	}

	private static int size = 0;
	CircularSingleNode<T> s = null;

	public CircularSingleLinkedList() {
		CircularSingleNode<T> n = new CircularSingleNode();
	}

	public CircularSingleLinkedList(T data, CircularSingleNode next) {
		CircularSingleNode<T> n = new CircularSingleNode(data, next);
	}

	@Override
	public void addAtEnd(T i) {
		if (s == null) {
			s = new CircularSingleNode(i, s);
			size++;
			return;
		}
		CircularSingleNode temp = s;
		do {
			temp = temp.getNext();
		} while (temp != s);
		CircularSingleNode newnode = new CircularSingleNode(i, s);
		temp.setNext(newnode);
		size++;
	}

	@Override
	public void addAtBegin(T i) {
		if (s == null) {
			s = new CircularSingleNode(i, s);
			size++;
			return;
		}
		CircularSingleNode temp = s;
		s = new CircularSingleNode(i, temp);
		size++;
	}

	@Override
	public void addAtPosition(int i, T p) {
		if (i < 0)
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
		CircularSingleNode temp = s;
		do {
			count++;
			if (count == i - 1) {
				CircularSingleNode temp2 = temp.getNext();
				temp = new CircularSingleNode(p, temp2);
			}
			temp = temp.getNext();
		} while (temp != s);
		size++;

	}

	@Override
	public void deleteAtPosition(int i) {
		if (s == null)
			return;
		if (s.getNext() == null) {
			s = null;
			size--;
		}
		CircularSingleNode temp = s;
		int count = 0;
		do {
			count++;
			if (count == i - 1) {
				CircularSingleNode temp2 = temp.getNext();
				temp2 = temp2.getNext();
				temp.setNext(temp2);
				break;
			}
			temp = temp.getNext();

		} while (temp != s);
		size--;
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
		CircularSingleNode temp = s;
		do {
			System.out.print(temp.getData() + ",");
			temp = temp.getNext();
		} while (temp != s);
		return;
	}

	@Override
	public T getElementAt(int i) {
		if (i <= 0 || i > size) {
			return null;
		}
		int count = 0;
		CircularSingleNode temp = s;
		do {
			if (count == i - 1)
				break;
			temp = temp.getNext();
		} while (temp != s);
		temp = temp.getNext();
		return (T) temp.getData();
	}

	@Override
	public T getFirstElement() {
		if (s == null) {
			return null;
		}
		return (T) s.getData();
	}

	@Override
	public T getLastElement() {
		return (T) getElementAt(size);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(T i) {
		CircularSingleNode temp = s;
		int flag = 0;
		int pos = 0;
		int count = 0;
		do {
			count++;
			if (temp.getData() == i) {
				flag = 1;
				pos = count;
			}
			temp = temp.getNext();
		} while (temp != s);
		if (flag == 1)
			return pos;
		else
			return -1;
	}

}
