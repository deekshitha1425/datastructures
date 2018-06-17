package com.deek.list;

public class ArrayList<T> implements List<T> {
	private Object[] storage;
	private static final int DEFAULT_SIZE = 10;
	private int size = 0;

	public ArrayList() {
		this(DEFAULT_SIZE);
	}

	public ArrayList(int size) {
		storage = new Object[size];
	}

	// []+a=[a]
	// [a]+b=[a,b]
	@Override
	public void addAtEnd(T i) {
		if (size >= storage.length) {
			Object[] temp = new Object[2 * storage.length];
			for (int index = 0; index < storage.length; index++) {
				temp[index] = storage[index];
			}
			storage = temp;
		}
		storage[size++] = i;
	}
	// []+a=[a]
	// [a]+b=[b,a]

	@Override
	public void addAtBegin(T i) {
		if (size >= storage.length) {
			Object[] temp = new Object[2 * storage.length];
			for (int index = 0; index < storage.length; index++) {
				temp[index] = storage[index];
			}
			storage = temp;

		}
		for (int index = size; index > 0; index--) {
			storage[index] = storage[index - 1];

		}
		storage[0] = i;
		size++;
	}

	// [a,b,c]+(1,d)=[a,d,b,c]
	@Override
	public void addAtPosition(int i, T p) {
		if (i > size || i < 0) {
			System.out.println("invalid position");
			return;
		}
		if (size >= storage.length) {
			Object[] temp = new Object[2 * storage.length];
			for (int index = 0; index < storage.length; index++) {
				temp[index] = storage[index];
			}
			storage = temp;
		}
		for (int index = size; index > i; index--) {
			storage[index] = storage[index - 1];
		}
		storage[i] = p;
		size++;
	}

	// [a,b,c]-(1)=[a,c,null]
	// [1,2,3,4,5,6,8,9,10,10]-(6)=[1,2,3,4,5,6,8,9,10,null]
	@Override
	public void deleteAtPosition(int i) {
		if (i >= size || size == 0 || i < 0) {
			System.out.println("invalid position");
			return;
		}
		if (size <= (storage.length / 2)) {
			Object[] temp = new Object[storage.length / 2];
			for (int index = 0; index < size; index++)
				temp[index] = storage[index];
			storage = temp;
		}
		for (int index = i; index < size; index++) {
			storage[index] = storage[index + 1];
		}
		storage[size] = null;
		size--;

	}

	// [a,b,c]=[a,b,null]
	@Override
	public void deleteAtEnd() {
		if (size == 0) {
			System.out.println("invalid");
			return;
		}
		storage[size--] = null;
	}

	// [a,b,c]=[b,c,null]
	@Override
	public void deleteAtBegin() {
		deleteAtPosition(0);
	}

	@Override
	public void print() {
		for (int index = 0; index <= size; index++) {
			System.out.print(storage[index] + ",");
		}
	}

	@Override
	public T getElementAt(int i) {
		if (i < 0 || i > size - 1) {
			System.out.println("invalid position");
			return null;
		}
		return (T) storage[i];
	}

	@Override
	public T getFirstElement() {
		if (size == 0)
			return null;
		return (T) storage[0];
	}

	@Override
	public T getLastElement() {
		if (size == 0)
			return null;
		return (T) storage[size - 1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(T i) {
		int pos = 0;
		for (int index = 0; index < size; index++) {
			if (storage[index] == i) {
				pos = index;
				break;
			}
		}
		return pos;
	}

}
