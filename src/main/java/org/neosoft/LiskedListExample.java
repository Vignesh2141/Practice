package org.neosoft;


public class LiskedListExample {
    public static void main(String[] args) {
        Node head = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(4);
        Node node4 = new Node(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Original linked list:");
        printLinkedList(head);

//        head=bubbleSort(head);

//        head=selectionSort(head);

//        head=mergeSort(head);

        head=insertionSortLinkedList(head);



        System.out.println("Linked list after Sorting:");
        printLinkedList(head);
    }

    private static Node insertionSortLinkedList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node current=head;
        Node sorted=null;

        while (current!=null){
            Node next=current.next;
            sorted = sortedList(sorted,current);
            current=next;
        }
        return sorted;
    }

    private static Node sortedList(Node sorted, Node newNode) {
        if(sorted==null || newNode.data<sorted.data){
            newNode.next=sorted;
            sorted=newNode;
        }else {
            Node current=sorted;
            while (current.next!=null && current.next.data<newNode.data){
                current=current.next;
            }
            newNode.next=current.next;
            current.next=newNode;
        }
        return sorted;
    }

    private static Node mergeSort(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        
        Node middle=getMiddle(head);
        Node nextToMiddle=middle.next;
        middle.next=null;

        Node left=mergeSort(head);
        Node right=mergeSort(nextToMiddle);

        return merge(left,right);
    }

    private static Node merge(Node left, Node right) {
        Node mergedList=new Node(-1);
        Node current=mergedList;

        while (left != null && right!=null){
            if(left.data < right.data){
                current.next=left;
                left=left.next;
            } else {
                current.next=right;
                right=right.next;
            }
            current=current.next;
        }
        if(left!=null){
            current.next=left;
        } else {
            current.next=right;
        }
        return mergedList.next;
    }

    private static Node getMiddle(Node head) {
        if(head == null){
            return head;
        }
        Node slow=head;
        Node fast=head.next;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private static Node selectionSort(Node head) {
        Node current=head;
        while (current!=null){
            Node minData=findMin(current);
            swapData(current,minData);
            current=current.next;
        }
        return head;
    }

    private static void swapData(Node current,Node minData) {
        int temp=current.data;
        current.data=minData.data;
        minData.data=temp;
    }

    private static Node findMin(Node head) {
        Node minNode=head;
        Node current=head.next;
        while (current!=null){
            if (current.data<minNode.data);
            minNode=current;
            current=current.next;
        }
        return minNode;
    }

    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private static Node bubbleSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        boolean swapped;
        do {
            swapped = false;
            Node prev = null;
            Node current = head;

            while (current.next != null) {
                Node next = current.next;

                if (current.data > next.data) {
                    if (prev != null) {
                        prev.next = next;
                    } else {
                        head = next;
                    }

                    current.next = next.next;
                    next.next = current;

                    prev = next;
                    swapped = true;
                } else {
                    prev = current;
                    current = next;
                }
            }
        } while (swapped);
        return head;
    }


//    private static void bubbleSort(Node head) {
//        if(head == null || head.next==null){
//            return;
//        }
//        boolean swapped;
//        do{
//            swapped=false;
//            Node prev=null;
//            Node current= head;
//            Node next=head.node;
//            while (next != null) {
//                if (current.data > next.data) {
//                    if(prev!=null){
//                        prev.node=next;
//                    }
//                    else head=next;
//
//                    current.node=next.node;
//                    next.node=current;
//                    prev=next;
//                    next=current.node;
//                    swapped=true;
//                }else {
//                    prev=current;
//                    current=next;
//                    next=current.node;
//                }
//            }
//        }while (swapped);
//    }

    private static void viewList(Node head) {
        Node currentNode=head;
        while (currentNode!=null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.println();
    }

    private static void addInEnd(Node head, int val) {
        Node newNode=new Node(val);
        Node currentNode=head;
        while (currentNode.next!=null){
            currentNode=currentNode.next;
        }
        currentNode.next=newNode;
    }


}
