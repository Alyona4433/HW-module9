package stack;

public class MyStack {

    private Node top;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds: " + index);
            return;
        }

        if (index == 0) {
            top = top.next;
        } else {
            Node prevNode = getNodeAtIndex(index - 1);
            prevNode.next = prevNode.next.next;
        }
        size--;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        return top.data;
    }

    public Object pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
        Object data = top.data;
        top = top.next;
        size--;
        return data;
    }

    private Node getNodeAtIndex(int index) {
        Node currentNode = top;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
}


