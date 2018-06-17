package com.deek.list;

public class SingleLinkedList<T> implements List<T> {

	public static class Node<T> {
		private T data;
		private Node<T> next;

		public Node() {
			data = null;
			next = null;
		}

		public Node(T element, Node n) {
			data = element;
			next = n;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

	}

	private Node s = null;

	public SingleLinkedList() {

		SingleLinkedList.Node n = new SingleLinkedList.Node();

	}

	public SingleLinkedList(int ele, Node p) {

		SingleLinkedList.Node n = new SingleLinkedList.Node(ele, p);

	}

	@Override
	public void addAtEnd(T i) {
		if (s == null) {
			s = new Node(i, null);

		} else {
			Node temp = s;
			while (temp != null) {
				temp = temp.next;
			}
			temp = new Node(i, null);
		}
		return;

	}

	@Override
	public void addAtBegin(T i) {
		if (s == null) {
			s = new Node(i, null);
		} else {
			Node temp = new Node(i, s);
			s = temp;
		}
		return;
	}

	@Override
	public void addAtPosition(int i, T p) {
		if (i < 0 || (s == null && i != 1))
			return;
		if (i == 1)
			addAtBegin(p);
		int count = 0;
		Node temp = s;
		while (temp != null) {
			count++;
			if (count == i - 1) {
				Node temp1 = temp.getNext();
				temp = new Node(i, temp1);
			}
			temp = temp.getNext();
		}
		return;
	}

	@Override
	public void deleteAtPosition(int i) {
		if (i < 0)
			return;
		if (s == null)
			return;
		if (i == 1) {
			s = null;
			return;
		}
		int count = 0;
		Node temp = s;
		while (temp != null) {
			count++;
			if (count == i - 1) {
				Node temp1 = temp;
				temp = temp.next;
				temp = temp.getNext();
				temp1.setNext(temp);
			}
			temp = temp.next;
		}
		return;

	}

	@Override
	public void deleteAtEnd() {
		if (s == null)
			return;
		if (s.getNext() == null) {
			s = null;
			return;
		}
		Node temp = s;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		return;
	}

	@Override
	public void deleteAtBegin() {
		deleteAtPosition(1);
	}

	@Override
	public void print() {
		if (s == null)
			return;
		Node temp = s;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.print(temp.data);
		return;
	}

	@Override
	public T getElementAt(int i) {
		if (s == null)
			return null;
		int count = 0;
		Node temp = s;
		while (temp != null) {
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
		else
			return (T) s.getData();
	}

	@Override
	public T getLastElement() {
		if (s == null)
			return null;
		else {
			Node temp = s;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			return (T) temp.getData();
		}

	}

	@Override
	public int size() {
		int count = 0;
		Node temp = s;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	@Override
	public int indexOf(T i) {
		int count = 0;
		Node temp = s;
		while (temp.getData() != i) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

}
