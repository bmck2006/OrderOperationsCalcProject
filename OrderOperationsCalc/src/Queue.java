/*
 * CLASS: Queue
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class implements a queue data structure using a Linked List to store elements.
 */
public class Queue<E> {

    private LinkedList<E> mList;

    /**
     * Constructor:
     * Creates empty Queue by creating a new empty LinkedList.
     */
    public Queue() {
        setList(new LinkedList());
    }

    /**
     * clear method:
     */
    public void clear() {
        getList().clear();
    }

    /**
     * dequeue method:
     * Removes and returns element at front of queue. 
     */
    public E dequeue() {
        E front = getList().remove(0);
        return front;
    }

    /**
     * enqueue method:
     * Adds to end of queue. 
     */
    public void enqueue(E pData) {
        getList().append(pData);
    }

    /**
     * getList method: Accessor:
     */
    protected LinkedList<E> getList() {
        return mList;
    }

    /**
     * isEmpty method: checks if list is empty.
     */
    public boolean isEmpty() {
        return getList().isEmpty();
    }

    /**
     * peek method: allows to view front method without removing.
     */
    public E peek() {
        return getList().get(0);
    }

    /**
     * setList: Mutator
     */
    protected void setList(LinkedList pList) {
        mList = pList;
    }

    /**
     * toString method:
     */
    @Override
    public String toString() {
        return getList().toString();
    }

}

