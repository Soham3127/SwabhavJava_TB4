package com.aurionpro.collections.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		// Creating a queue
		PriorityQueue<String> queue = new PriorityQueue<>();

		// Adds elements to the queue
		queue.add("Amit Sharma");
		queue.add("Vijay Raj");
		queue.add("JaiShankar");
		queue.add("Raj");
		System.out.println("Queue after add(): " + queue);

		// offer similar to add
		queue.offer("Zubin Mehta");
		System.out.println("Queue after offer(): " + queue);

		// Returns the number of elements
		System.out.println("Size of queue: " + queue.size());

		// Checks if the queue is empty(boolean)
		System.out.println("Is queue empty? " + queue.isEmpty());

		// Checks if a specific element exists
		System.out.println("Does queue contain 'Raj'? " + queue.contains("Raj"));

		// Retrieves the head if the queue
		System.out.println("Head using peek(): " + queue.peek());

		// throws exception if queue is empty
		System.out.println("Head using element(): " + queue.element());

		// iterator()

		System.out.println("Iterating using iterator():");
		Iterator<String> itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Removes the head element
		String removed1 = queue.remove();
		System.out.println("Removed using remove(): " + removed1);

		// poll() Removes the head element, returns null if empty
		String removed2 = queue.poll();
		System.out.println("Removed using poll(): " + removed2);

		// clear . Removes all elements from queue
		queue.clear();
		System.out.println("Queue after clear(): " + queue);
		System.out.println(" queue:  " + queue.isEmpty());

	}
}
