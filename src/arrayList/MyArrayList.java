package arrayList;

public class MyArrayList {

    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    public Object get(int index) {

        return data[index];
    }

    public int size() {
        return size;
    }


    public void remove(int index) {
        data[size - 1] = null; // Let the garbage collector handle the removed object
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }


    public void add(Object value) {
        capacity(size + 1);
        data[size] = value;
        size++;
    }

    private void capacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
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