package queue;

public class MyQueue {

    private Node front;
    private Node rear;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    public Object poll() {
        if (front == null) {
            return null;
        }
        Object data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add("sdfsdfgsdfg");
        myQueue.add("hkhjkhjkhjk");
        myQueue.add("ertertertet");

        System.out.println("myQueue.size() = " + myQueue.size());

        System.out.println("myQueue.peek() = " + myQueue.peek());

        System.out.println("myQueue.poll() = " + myQueue.poll());

        System.out.println("myQueue.size() = " + myQueue.size());

        myQueue.clear();
    }
}

