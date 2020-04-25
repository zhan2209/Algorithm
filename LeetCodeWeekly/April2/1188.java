class BoundedBlockingQueue {
    private volatile int size = 0;
    private volatile int capacity;
    private Node head;
    private Node tial;
    private final Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();
    
    class Node {
        int val;
        Node next;
        Node previous;
        
        Node(int val){
            this.val = val;
        }
    }

    public BoundedBlockingQueue(int capacity) {
        
        this.capacity = capacity;
        
        head = new Node(-1);
        tial = new Node(-1);
        
        head.next = tial;
        tial.previous = head;
        
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        
        try{
            while(size == capacity){
                notFull.await();
            }
            
            Node temp = new Node(element);
            
            temp.next = head.next;
            head.next.previous = temp;
            head.next = temp;
            temp.previous = head;
            
            notEmpty.signal();
            size++;
        }finally{
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        try{
            while(size == 0){
                notEmpty.await();
            }
            
            Node temp = tial.previous;
            tial.previous = null;
            temp.next = null;
            tial = temp;
            size--;
            notFull.signal();
            return temp.val;
        }finally{
            lock.unlock();
        }
    }
    
    public int size() {
        return size;
        
    }
}