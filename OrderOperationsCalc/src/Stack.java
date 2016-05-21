/*
 * CLASS: Stack<E>
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class implements stack data structure, using a Linked List to store elements.
 */
public class Stack<E> {

    private LinkedList<E> mList;

    /**
     * Constructor:
     * Creates new empty stack by creating an empty linked list.
     */
    public Stack() {
        setList(new LinkedList());
    }

    /**
     * clear method:
     */
    public void clear() {
        getList().clear();
    }

    /**
     * getList method: Accessor
     */
    protected LinkedList<E> getList() {
        return mList;
    }

    /**
     * isEmpty method:
     */
    public boolean isEmpty() {
        return getList().isEmpty();
    }

    /**
     * peek method: views top element without removing. 
     */
    public E peek() {
        return getList().get(0);
    }

    /**
     * pop method:
     * Removes the top element from the Stack and returns it.
     */
    public E pop() {
        E top = getList().remove(0);
        return top;
    }

    /**
     * push method;
     * pushes pData onto the top of the Stack.
     */
    public void push(E pData) {
        getList().prepend(pData);
    }

    /**
     * setList method: mutator.
     */
    protected void setList(LinkedList<E> pList) {
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
