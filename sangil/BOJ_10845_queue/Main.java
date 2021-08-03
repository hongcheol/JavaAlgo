package sangil.BOJ_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Node로 Linked List 형태의 queue를 구현
public class Main {
	
	private Node firstNode;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Main queue = new Main();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				queue.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(queue.pop()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.empty()).append("\n");
				break;
			case "front":
				sb.append(queue.front()).append("\n");
				break;
			case "back":
				sb.append(queue.back()).append("\n");
				break;
				
			default:
				break;
			}
		}
		System.out.println(sb);
	}
	
	public Main() {
		this.firstNode = new Node();
	}
	public void push(int n) {
		if(empty()==1) {
			firstNode.setNext(new Node(n));			
		} else {
			Node nextNode = firstNode.getNext();
			while(nextNode.getNext()!=null) {
				nextNode = nextNode.getNext();
			}
			nextNode.setNext(new Node(n));
		}
	}
	
	public int pop() {
		int result = -1;
		Node nextNode = firstNode.getNext();
		if(nextNode!=null) {
			result = nextNode.getData();
			if(nextNode.getNext() != null) {
				firstNode.setNext(nextNode.getNext());
			} else {
				firstNode.setNext(null);
			}
		}
		return result;
	}
	
	public int size() {
		int result = 0;
		Node nextNode = firstNode.getNext();
		while(nextNode!=null) {
			result++;
			nextNode = nextNode.getNext();
		}
		return result;
	}
	
	public int empty() {
		int result = 1;
		if(firstNode.getNext()!=null) {
			result = 0;
		}
		return result;
	}
	
	public int front() {
		int result = -1;
		if(empty() == 0) {
			result = firstNode.getNext().getData();
		}
		return result;
	}
	
	public int back() {
		int result = -1;
		if(empty() == 0) {
			Node nextNode = firstNode.getNext();
			while(nextNode.getNext()!=null) {
				nextNode = nextNode.getNext();
			}
			result = nextNode.getData();
		}
		return result;
	}
	
	private class Node {
		private Node next;
		private int data;
		
		public Node() {
			
		}
		public Node(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
	}
}
