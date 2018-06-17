package com.deek.list;

public class DoubleLinkedList<T> implements List<T> {
	public static class DoubleNode<T> {
		private T data;
		private DoubleNode<T> previous;
		private DoubleNode<T> next;

		public DoubleNode() {
			data = null;
			previous = null;
			next = null;
		}

		public DoubleNode(T d, DoubleNode p, DoubleNode n) {
			data = d;
			previous = p;
			next = n;
		}

		public DoubleNode<T> getNext() {
			return next;
		}

		public void setNext(DoubleNode<T> next) {
			this.next = next;
		}

		public DoubleNode<T> getPrevious() {
			return previous;
		}

		public void setPrevious(DoubleNode<T> previous) {
			this.previous = previous;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

	}

	private DoubleNode s = null;
	private static int size = 0;

	public DoubleLinkedList() {
		DoubleNode n = new DoubleNode();
	}

	public DoubleLinkedList(T data, DoubleNode p, DoubleNode n) {
		DoubleNode newnode = new DoubleNode(data, p, n);
	}

	@Override
	public void addAtEnd(T i) {
		if (s == null) {
			s = new DoubleNode(i, null, null);
			size++;
			return;
		}
		DoubleNode temp = s;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		size++;
	}

	@Override
	public void addAtBegin(T i) {
		if (s == null) {
			s = new DoubleNode(i, null, null);
			size++;
			return;
		}
		DoubleNode temp = new DoubleNode(i, null, null);
		temp.setNext(s);
		s.setPrevious(temp);
		s = temp;
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
		DoubleNode temp = s;
		int count = 0;
		while (temp != null) {
			count++;
			if (count == i - 1) {
				DoubleNode newnode = new DoubleNode(i, null, null);
				DoubleNode temp2 = temp.getNext();
				temp.setNext(newnode);
				newnode.setPrevious(temp);
				temp2.setPrevious(newnode);
				newnode.setNext(temp2);
			}
			temp = temp.getNext();
		}
		size++;
	}

	@Override
	public void deleteAtPosition(int i) {
		if (s == null || i < 0)
			return;
		DoubleNode temp = s;
		int count = 0;
		while (temp != null) {
			count++;
			if (count == i - 1) {
				DoubleNode temp2 = temp.getNext();
				temp2 = temp2.getNext();
				temp2.setPrevious(temp);
				temp.setNext(temp2);

			}
			temp = temp.getNext();
		}
		size--;
	}

	@Override
	public void deleteAtEnd() {
		if (s == null)
			return;
		if (s.getNext() == null) {
			s = null;
			return;
		}
		deleteAtPosition(size);
		return;

	}

	@Override
	public void deleteAtBegin() {
		if (s == null)
			return;
		if (s.getNext() == null) {
			s = null;
			return;
		}
		deleteAtPosition(1);
		return;
	}

	@Override
	public void print() {
		if (s == null)
			return;
		DoubleNode temp = s;
		while (temp != null) {
			System.out.print(temp.getData() + ",");
			temp = temp.getNext();
		}
		return;
	}

	@Override
	public T getElementAt(int i) {
		if (s == null || i < 0 || i > size) {
			return null;
		}
		DoubleNode temp = s;
		int count = 0;
		while (temp != null) {
			count++;
			if (count == i - 1)
				break;
			temp = temp.getNext();
		}
		temp = temp.getNext();
		return (T) temp.getData();

	}

	@Override
	public T getFirstElement() {
		if (s == null)
			return null;
		else
			return (T) s.getData();
	}

	@Override
	public T getLastElement() {
		if (s == null)
			return null;
		if (s.getNext() == null)
			return (T) s.getData();
		return getElementAt(size);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(T i) {
		int flag = 0;
		DoubleNode temp = s;
		int pos = 0;
		int count = 0;
		while (temp != null) {
			count++;
			if (temp.getData() == i) {
				flag = 1;
				pos = count;
				break;
			}
			temp = temp.getNext();
		}
		if (flag == 1)
			return pos;
		else
			return -1;
	}

}
