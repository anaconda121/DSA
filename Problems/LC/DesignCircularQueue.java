class DesignCircularQueue {
    int[] vals;
    int size;
    int front;
    int rear;
    int nextOpen;
    int numberInsert;
    int numberDelete;

    public DesignCircularQueue(int k) {
        vals = new int[k];
        size = 0;
        front = 0;
        rear = 0;
        nextOpen = 0;
        numberInsert = 0;
        numberDelete = 0;
    }

    public boolean enQueue(int value) {
        if (size < vals.length) {
            vals[nextOpen] = value;
            numberInsert++;
            rear = (numberInsert - 1) % vals.length;
            nextOpen = (numberInsert) % vals.length;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (size > 0) {
            vals[front] = -1;
            numberDelete++;
            front = (numberDelete) % vals.length;
            size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (size == 0) return -1;
        return vals[front];
    }
    
    public int Rear() {
        if (size == 0) return -1;
        return vals[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == vals.length;
    }
}
