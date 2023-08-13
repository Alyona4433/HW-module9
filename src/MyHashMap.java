public class MyHashMap <K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Node<K, V>[] buckets;
    private int size;

    public MyHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        int hash = (key == null) ? 0: key.hashCode();
        int hash = key.hashCode();
        int index = getIndex(hash);

        Node <K ,V> newNode = new Node<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode;
        } else {
            Node <K,V>current = buckets[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newNode;
            }
        }
        size++;

        if ((double) size / buckets.length >= LOAD_FACTOR) {
            resizeBuckets();
        }
    }

    private void resizeBuckets() {
        int newCapacity = buckets.length * 2;
        Node<K,V>[] newBuckets = new Node[newCapacity];

        for (Node<K,V> node : buckets) {
            while (node != null) {
                int newIndex = getIndex((node.key == null) ? 0 : node.key.hashCode(), newCapacity);

                int newIndex = getIndex(node.key.hashCode(), newCapacity);
                Node<K, V> newNode = new Node<>(node.key, node.value);

                if (newBuckets[newIndex] == null) {
                    newBuckets[newIndex] = newNode;
                } else {
                    Node<K, V> current = newBuckets[newIndex];
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }

                node = node.next;
            }
        }

        buckets = newBuckets;
    }

    public void remove(K key) {
        int hash = (key == null) ? 0 : key.hashCode();

        int hash = key.hashCode();
        int index = getIndex(hash);

        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hash = (key == null) ? 0 : key.hashCode();

        int hash = key.hashCode();
        int index = getIndex(hash);

        Node current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndex(int hash) {
        return getIndex(hash, buckets.length);
    }

    private int getIndex(int hash, int capacity) {
        return hash % capacity;
    }

    private static class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}

