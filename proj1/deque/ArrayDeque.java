package deque;

/**
 * @author Sen Yan
 * @create 2021-04-12-11:41
 */
public class ArrayDeque<T> {

    private int DEFAULT_CAPACITY = 8;
    private T[] array;
    private int size;

    public ArrayDeque() {
        array = (T[])new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other){
        int sizeOther = other.size();
        array = (T[])new Object[sizeOther];
        for (int i = 0; i < sizeOther; i++) {
            array[i] = (T) other.get(i);
        }
    }
    public void addFirst(T item){
        if(size == DEFAULT_CAPACITY){
            growArrayDeque();
        }
        T[] copy = (T[])new Object[size];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        for (int i = 0; i < size; i++) {
            array[i + 1] = copy[i];
        }
        array[0] = item;
        size += 1;
    }

    private void growArrayDeque() {
        DEFAULT_CAPACITY *= 2;
        T[] copy = (T[])new Object[DEFAULT_CAPACITY];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    public void addLast(T item){
        if(size == DEFAULT_CAPACITY){
            growArrayDeque();
        }
        array[size] = item;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }
        T first = array[0];
        if(size == DEFAULT_CAPACITY + 1){
            T[] copy = (T[])new Object[DEFAULT_CAPACITY / 2];
            for (int i = 0; i < size; i++) {
                copy[i] = array[i + 1];
            }
            DEFAULT_CAPACITY /= 2;
            size -= 1;
            array = copy;
        }else{
            array[0] = null;
            for (int i = 1; i < size; i++) {
                array[i-1] = array[i];
            }
            size -= 1;
        }
        return first;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T last = array[size - 1];
        if(size == DEFAULT_CAPACITY + 1){
            T[] copy = (T[])new Object[DEFAULT_CAPACITY / 2];
            for (int i = 0; i < size - 1; i++) {
                copy[i] = array[i];
            }
            size -= 1;
            DEFAULT_CAPACITY /= 2;
            array = copy;

        }else{
            array[size - 1] = null;
            size -= 1;
        }
        return last;

    }

    public T get(int index){
        return array[index];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addFirst(5);
        d.addFirst(10);
        d.addFirst(15);
        d.addFirst(20);
        d.addLast(6);
        d.addLast(7);
        d.addLast(8);
        d.addLast(9);
        d.addLast(10);
        d.addLast(11);
        d.addLast(12);
        d.addLast(13);
        d.addLast(14);
        d.printDeque();
        System.out.println("size:"+d.size());
        System.out.println(d.get(5));
        d.removeLast();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.printDeque();
    }

}
