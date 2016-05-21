/*
 * CLASS: LinkedList
 * Brian McKeown
 * CSE 205: Spring 2016, B Session
 * 
 * This class implements a doubly linked list,
 * where the type of each element is E. 
 */

public class LinkedList<E> {
  
    private Node mHead; // head node of list.
    private Node mTail; // tail node of list.
    private int mSize; // size of linked list. 


    /**
     * Constructor: creates empty linked list.
     */
    public LinkedList() {
        setHead(null);
        setTail(null);
        setSize(0);
    }

    /**
     * Constructor: creates linked list with one element containing data.
     * Sets head and tail nodes, as well as size to 1. 
     */
    public LinkedList(E pData) {
        Node newNode = new Node(pData);
        setHead(newNode);
        setTail(newNode);
        setSize(1);
    }

    /**
     * add method: adds a new node containing data. 
     */
    public void add(int pIndex, E pData) throws IndexOutOfBoundsException {
        // Check if pIndex is out of bounds.
        if (pIndex < 0 || pIndex > getSize()) throw new IndexOutOfBoundsException();

        // if appending:
        if (pIndex == getSize()) {
            Node newNode = new Node(pData, getTail(), null);

        if (isEmpty()) 
            setHead(newNode);
        else 
        	getTail().setNext(newNode);
        
        setTail(newNode);
        }

        // if not appending.
        else {
            // Gets a reference to the Node at pIndex.
            Node node = getNodeAt(pIndex);

            // Creates a new Node storing pData.
            Node newNode = new Node(pData, node.getPrev(), node);

            if (pIndex != 0) 
            	node.getPrev().setNext(newNode);
            
            node.setPrev(newNode);

            // if inserting at index 0
            if (pIndex == 0) 
            	setHead(newNode);
        }

        // Increments size of list. 
        setSize(getSize() + 1);
    }

    /**
     * append method:
     */
    public void append(E pData) {
        add(getSize(), pData);
    }

    /**
     * clear method: removes all of the elements from the linked list.
     */
    public void clear() {
        while (!isEmpty()) { 
        	remove(0); 
        	}
    }

    /**
     * get method: returns the element at requested index. 
     */
    public E get(int pIndex) throws IndexOutOfBoundsException {
        return (E)getNodeAt(pIndex).getData();
    }

    /**
     * getHead method:
     */
    protected Node getHead() {
        return mHead;
    }

    /**
     * getNodeAt method: returns a reference to the Node at the requested index.
     */
     
     
    protected Node getNodeAt(int pIndex) throws IndexOutOfBoundsException {
        // Check for pIndex out of bounds and throw exception is necessary.
        if (pIndex < 0 || pIndex >= getSize()) throw new IndexOutOfBoundsException();

        // Since accessing the head and tail nodes is a common operation we check for those cases
        // first.
        if (pIndex == 0) return getHead();
        else if (pIndex == getSize() - 1) return getTail();

        // Otherwise, start at the node at index 1 and walk forward until the node at index pIndex
        // is reached and then return it.
        Node node = getHead().getNext();
        for (int index = 1; index < pIndex; ++index) node = node.getNext();
        return node;
    }

    /**
     * getSize method: returns size of list.
     */
    public int getSize() {
        return mSize;
    }

    /**
     * getTail method: returns tail Node. 
     */
    protected Node getTail() {
        return mTail;
    }

    /**
     * isEmpty method: checks to see if linked list is empty.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * prepend method: prepends Node to linked list. 
     */
    public void prepend(E pData) {
        add(0, pData);
    }

    /**
     * remove method: removes the element at requested index from the linked list.
     */
    public E remove(int pIndex) throws IndexOutOfBoundsException {
        Node node = getNodeAt(pIndex);

        // if removing from a list with only 1 Node.
        if (getSize() == 1) {
            setHead(null);
            setTail(null);
        }

        // if removing head from list with more than 1 element.  
        else if (pIndex == 0) {
            node.getNext().setPrev(null);
            setHead(node.getNext());
        }

        // if removing tail node from list with more than 1 element.
        else if (pIndex == getSize() - 1) {
            node.getPrev().setNext(null);
            setTail(node.getPrev());
        }

        // if not removing head or tail.
        else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }

        // decrease size of list by 1. 
        setSize(getSize() - 1);

        // returns data stored at node. 
        return (E)node.getData();
    }

    /**
     * set method: replaces the element at the specified position in this list with the specified element.
     * returns the element that was previously stored at the selected index.
     */
    public E set(int pIndex, E pData) throws IndexOutOfBoundsException {
        Node node = getNodeAt(pIndex);
        E original = (E)node.getData();
        node.setData(pData);
        return original;
    }

    //Mutator Methods:
    
    /**
     * setHead method:
     */
    protected void setHead(Node pHead) {
        mHead = pHead;
    }

    /**
     * setSize method:
     */
    protected void setSize(int pSize) {
        mSize = pSize;
    }

    /**
     * setTail method:
     */
    protected void setTail(Node pTail) {
        mTail = pTail;
    }

    /**
     * toString method:
     */
    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < getSize(); ++i) string += get(i) + " ";
        return string;
    }
    /*************************/
    /*** Nested Node Class ***/
    /*************************/
    protected static class Node<E> {
       
        E mData; // data stored in Node object.
        Node mNext; // reference to next node in list. 
        Node mPrev; // reference to previous node in list. 

        /**
         * Constructor: default
         */
        public Node() {
            this(null);
        }

        /**
         * Constructor: stores data element. 
         */
        public Node(E pData) {
            setData(pData);
            setNext(null);
            setPrev(null);
        }

        /**
         * Constructor: stores data element, and reference to prev and next nodes.
         */
        public Node(E pData, Node pPrev, Node pNext) {
            setData(pData);
            setPrev(pPrev);
            setNext(pNext);
        }

        /**
         * Returns true if this Node and pNode are equal to each other where equal is defined as:
         *
         * 1. pNode is not null.
         * 2. mNode == pNode.
         * 3. The instance variables of this Node == instance variables of pNode
         */
        @Override
        public boolean equals(Object pNode) {
            Node node = (Node)pNode;
            if (node == null) return false;
            if (this == node) return true;
            if (getData() == node.getData() && getNext() == node.getNext() &&
            getPrev() == node.getPrev()) return true;
            return false;
        }

        //Accessor methods:

        public E getData() {
            return mData;
        }

        public Node getNext() {
            return mNext;
        }

        public Node getPrev() {
            return mPrev;
        }

        // Mutator methods:
        
        public void setData(E pData) {
            mData = pData;
        }

        public void setNext(Node pNext) {
            mNext = pNext;
        }

        public void setPrev(Node pPrev) {
            mPrev = pPrev;
        }

        //toString method:
        @Override
        public String toString() {
            return "" + getData();
        }
    }
}

