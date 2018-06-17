package com.deek.list;

public interface List<T> {
	void addAtEnd(T i);

	void addAtBegin(T i);

	void addAtPosition(int i, T p);

	void deleteAtPosition(int i);

	void deleteAtEnd();

	void deleteAtBegin();

	void print();

	T getElementAt(int i);

	T getFirstElement();

	T getLastElement();

	int size();

	int indexOf(T i);
}
