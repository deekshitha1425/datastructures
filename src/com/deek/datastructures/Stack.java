package com.deek.datastructures;

public class Stack {
	int top = -1;
	int size;
	int[] a;

	public Stack(int n) {
		a = new int[n];
		size = n;
	}

	public void push(int n) {

		if (top < size) {
			top++;
			a[top] = n;

		} else {
			System.out.println("stack is full");
		}
	}

	public int pop() {
		if (top == -1) {
			System.out.println("underflow");
			return -1;
		} else {
			int x = a[top];
			top--;
			return x;
		}

	}

	public void print() {
		for (int i = top; i >= 0; i--) {
			System.out.print(a[i] + ",");
		}
	}
}
