package deque;

public class ArrayDeque<T> {
    private T[] arr = (T []) new Object[8];
    private int size;
    private int front;
    private int back;

    public void addFirst(T item){
        front = minusOne(front);
        arr[front] = item;
        size++;
        if (size == 1) {
            back = front;
        }
    }

    public void addLast(T item){
        back = plusOne(back);
        arr[back] = item;
        size++;
        if (size == 1) {
            front = back;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i = front;
        for (int j = 0; j < size; j++){
            System.out.print(arr[i] + " ");
            i = plusOne(i);
        }
        System.out.println();
    }

    public T removeFirst(){
        T removed = arr[front];
        if (removed != null){
            arr[front] = null;
            size--;
            if (size != 0){
                front = plusOne(front);
            }
        }
        return removed;
    }

    public T removeLast(){
        T removed = arr[back];
        if (removed != null){
            arr[back] = null;
            size--;
            if (size != 0){
                back = minusOne(back);
            }
        }
        return removed;
    }

    public T get(int index){
        return arr[plusMultiple(front, index)];
    }

    public ArrayDeque(){
        size = 0;
        front = 0;
        back = 0;
    }

    private int minusOne(int index){
        if (index == 0){
            return arr.length - 1;
        }
        return index - 1;
    }

    private int plusOne(int index){
        if (index == arr.length - 1){
            return 0;
        }
        return index + 1;
    }

    private int plusMultiple(int start, int addition){
        if (start + addition >= arr.length){
            return start + addition - arr.length;
        }
        return start + addition;
    }

//    private int resize(){
//
//    }

//    public Iterator<T> iterator(){}

//    public boolean equals(Object o){}
}
