package arrayList;

public class MyArrayList<T> {

    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int size() {
        return size;
    }


    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public void add(T value) {
        capacity(size + 1);
        data[size] = value;
        size++;
    }

    private void capacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            T[] newData = (T[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add("Bla-bla-bla");
        myArrayList.add("to=to-to");
        myArrayList.add("rrr");

        System.out.println("myArrayList.size() = " + myArrayList.size());

        myArrayList.remove(2);

        System.out.println("myArrayList.get(1) = " + myArrayList.get(1));

        myArrayList.clear();





    }
}