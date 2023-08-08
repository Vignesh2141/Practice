package org.neosoft;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(21);
        st.push(12);
        st.push(65);
        st.push(11);

        printStack(st);
        bubbleSort(st);
        System.out.println("stack after Sorting");
        printStack(st);
    }

//    private static void bubbleSortStack(Stack<Integer> st) {
//        Stack<Integer> st2=new Stack<>();
//
//        int size=st.size();
//        for (int i=0;i<size;i++) {
//            boolean swapped=false;
//            for (int j = 0; j <size-i ; j++) {
//                int current = st.pop();
//                if (!st.isEmpty()) {
//                    int next = st.peek();
//                    if (current > next) {
//                        st2.push(current);
//                        swapped = true;
//                    } else {
//                        st2.push(next);
//                        st.pop();
//                        st.push(current);
//                    }
//                } else {
//                     st2.push(current);
//                }
//            }
//
//            for (int j = 0; j <size-i ; j++) {
//                st.push(st2.pop());
//            }
//            if (!swapped){
//                break;
//            }
//        }
//    }

    private static void bubbleSort(Stack<Integer> stack) {
        int size = stack.size();
        boolean swapped;

        for (int i = 0; i < size - 1; i++) {
            swapped = false;

            for (int j = 0; j < size - i - 1; j++) {
                int current = stack.pop();
                int next = stack.peek();

                if (current > next) {
                    stack.pop();
                    stack.push(current);
                    stack.push(next);
                    swapped = true;
                } else {
                    stack.push(current);
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
    private static void printStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            int element = stack.pop();
            tempStack.push(element);
            System.out.print(element + " ");
        }
        System.out.println();

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
//    private static void viewStack(Stack<Integer> st) {
//        st.stream().forEach(ele->{
//            System.out.print(ele+" ");
//        });
//    }
}
