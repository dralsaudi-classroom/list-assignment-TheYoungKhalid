package com.example.project;

public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean full() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T e) {
		current.data = e;
	}

	public void insert(T e) {
		if (empty()) {
			current = head = new Node<T>(e);
		} else {
			Node<T> tmp = current.next;
			current.next = new Node<T>(e);
			current = current.next;
			current.next = tmp;
		}
	}

	public void remove() {
		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;
			while (tmp.next != current) {
				tmp = tmp.next;
			}
			tmp.next = current.next;
		}
		if (current.next == null) {
			current = head;
		} else {
			current = current.next;
		}
	}

	public T mostFrequentElement() {
		Node<T> tmp = head;
		Node<T> counterCurrent = head;
		int mostFreqCount = 0;
		int tmpCount = 0;
		current = head;

		while (current != null) {
			while (counterCurrent != null) {
				if (current.data == counterCurrent.data) {
					tmpCount++;
				}
				counterCurrent = counterCurrent.next;
			}
			if (tmpCount > mostFreqCount) {
				mostFreqCount = tmpCount;
				tmp = current;
			}
			tmpCount = 0;
			counterCurrent = current.next;
			current = current.next;
		}
		return (T) tmp.data;

		// Write the method mostFrequentElement, member of the class LinkedList, that
		// returns
		// the most frequent element in the list. The most frequent element is the
		// element
		// appearing the highest number of times. If one or more element appear the same
		// number of times, the one encountered earlier is returned.
		// Example 1.1. Given the list l : A, B, C, B, C, D, E, mostFrequentElement()
		// returns
		// B.
	}
}
