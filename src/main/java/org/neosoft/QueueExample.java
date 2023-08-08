package org.neosoft;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(2);
        queue.add(8);
        queue.add(1);
        queue.add(3);

        System.out.println("Queue before sorting: " + queue);

        bubbleSortQueue(queue);

        System.out.println("Queue after sorting: " + queue);
    }

    private static void bubbleSortQueue(Queue<Integer> queue) {
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int first = queue.poll();
                int second = queue.peek();
                if (first > second) {
                    queue.add(first);
                    queue.poll();
                }
                queue.add(second);
            }
        }
    }



}
