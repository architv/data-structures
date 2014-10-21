package Stacks;

import java.util.Scanner;

public class StacksUsingLinkedList {
	
	public static boolean balancedParanthesis(Stack s, String input) {
		
		for (int i = 0; i < input.length(); i++) {
			
			if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '(') {
				s.push(input.charAt(i));
			}
			
			else if (input.charAt(i) == '}') {
				int top = s.pop();
				if (top != '{') 
					return false;
			}
			
			else if (input.charAt(i) == '}') {
				int top = s.pop();
				if (top != '{') 
					return false;
			}
			
			else if (input.charAt(i) == ']') {
				int top = s.pop();
				if (top != '[') 
					return false;
			}
			
			else if (input.charAt(i) == ')') {
				int top = s.pop();
				if (top != '(') 
					return false;
			}
					
		}
		
		if (s.isEmpty())
			return true;
		
		return false;	
	}

	public static void reverse (Stack s1, Stack s2) {
		
		if (s1.isEmpty()) {
			return;
		}
		
		int top = s1.pop();
		reverse(s1, s2);
		s2.push(top);
		
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public static void reversedStack(Stack s1, Stack s2) {
		 
//		int size = s1.size();
		if (s1.isEmpty()) {
//			s2.push(s1.pop());
			return;
		}
		int top = s1.pop();
		reversedStack(s1, s2);
		
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		s1.push(top);
		
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}	
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
//		Stack s = new Stack();
//		Stack s2 = new Stack();
//		StackDA<String> s3 = new StackDA<String>();
//		s3.push("Hi");
//		s3.push("this");
//		s3.push("is");
//		s3.push("Archit");
//		s3.push("here");
//		s3.push("!");
////		s.push(25);
////		s.push(20);
////		s.push(15);
////		s.push(10);
////		s.push(5);
////		//s.pop();
////		//s.pop();
////		System.out.println(s.top());
////		System.out.println(s.isEmpty());
////		System.out.println(s.size);
////		printLinkedList(s.head);
//		
////		System.out.println(balancedParanthesis(s, "{a+[b+(c+d)]+(e+f)}"));
////		System.out.println("Before Reversal");
////		printLinkedList(s.head);
////		reversedStack(s, s2);
////		System.out.println("After Reversal");
////		//reverse(s, s2);
////		printLinkedList(s.head);
//		while (!s3.isEmpty()) {
//			System.out.println(s3.pop());
//		}
		MinStack m = new MinStack();
		int data = console.nextInt();
		
		while (data != -1) {
			m.push(data);
			data = console.nextInt(); 
		}
		
		System.out.println("minimum: " + m.getMinimum());
		System.out.println("pop: " + m.pop());
		System.out.println("minimum: " +m.getMinimum());
		System.out.println("pop: " +m.pop());
		System.out.println("minimum: " +m.getMinimum());
		System.out.println("pop: " +m.pop());
		System.out.println("minimum: " +m.getMinimum());
		System.out.println("pop: " +m.pop());
		System.out.println("minimum: " +m.getMinimum());
		System.out.println("pop: " +m.pop());
		System.out.println("minimum: " +m.getMinimum());
		System.out.println("pop: " +m.pop());
		System.out.println("minimum: " +m.getMinimum());
		System.out.println("pop: " +m.pop());
		System.out.println("minimum: " +m.getMinimum());
		
	}
	
	public static void printLinkedList(Node head) {
		
		boolean first = true;
		Node temp = head;
		
		while (temp != null) {
			if (first) {
				System.out.print(temp.data);
				first = false;
			} else {
				System.out.print("-->" + temp.data);
			}
			temp = temp.next;
		}
		
		System.out.println();
	}

}
