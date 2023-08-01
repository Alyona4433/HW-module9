package linkedList;

public class OwnLL <T> {
    private Node <T> firstNode;
    private Node <T> lastNode;
    private int size;

// Завдання 2 - метод додавання
    public void add(T val) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, val);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, val);
            firstNode.setNextNode(lastNode);
        } else {
            Node <T> node = new Node<>(lastNode, null, val);
            lastNode.setNextNode(node);
            lastNode = node;
        }
        size++;

    }

    public void remove (int index) {
        if (index == 0) {
            if (firstNode == null) {
                return; // Nothing to remove
            }
            firstNode = firstNode.getNextNode();
            if (firstNode == null) {
                lastNode = null; // The only element was removed
            } else {
                firstNode.setPrevNode(null);
            }
            return;
        }
        size--;

        Node <T> currentNode = firstNode;

        Node<T> prevNode = currentNode.getPrevNode();
        Node <T> nextNode = currentNode.getNextNode();

        if (prevNode != null) {
            prevNode.setNextNode(nextNode);
        } else {
            firstNode = nextNode;
        }
        if (nextNode != null) {
            nextNode.setPrevNode(prevNode);
        } else {
            lastNode = prevNode;
        }
        size--;

    }

    public void clear() {
        firstNode = null;
        lastNode = null;

    }

    public int size() {
        return size;
    }




    public static void main(String[] args) {
        OwnLL <String> ownLL = new OwnLL();
        ownLL.add("My");
        ownLL.add("first");
        ownLL.add("Linked");
        ownLL.add("List");
        ownLL.add("-----");

        //ownLL.remove(0);

        //ownLL.clear();

        int size = ownLL.size();
        System.out.println("Size = " + size);

        ownLL.get(1);


        int i = 0;
        while (true) {
            String element = ownLL.get(i);
            if (element == null) {
                break;
            }
            System.out.println(element);
            i++;
        }
    }

    public T get(int index) {
        Node <T> currentNode = firstNode;
        if (currentNode == null) {
            return null;
        }

        if (index == 0) {
            return currentNode.getValue();
        }
        for (int i = 0; i<index; i++) {
            currentNode = currentNode.getNextNode();

            if (currentNode == null) {
                return null;
            }
        }
        return currentNode.getValue();
    }

}