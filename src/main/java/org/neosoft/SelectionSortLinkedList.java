package org.neosoft;

import java.util.LinkedList;

public class SelectionSortLinkedList {

    public static void selectionSortLinkedList(LinkedList<Integer> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(8);
        linkedList.add(1);
        linkedList.add(3);

        System.out.println("Linked List before sorting: " + linkedList);

        selectionSortLinkedList(linkedList);

        System.out.println("Linked List after sorting: " + linkedList);
    }
}

