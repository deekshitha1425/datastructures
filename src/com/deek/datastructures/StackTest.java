package com.deek.datastructures;

public class StackTest {
	public static void main(String[] args) {
		Stack s = new Stack(5);
		s.push(4);
		s.push(5);
		System.out.println(s.pop());
		s.print();

	}

}
