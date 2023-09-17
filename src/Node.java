public class Node<T> { // this is class for node, structure her,node   have value    for specific value ,and have  4 pointers ,2 two pointer for doubleLinked list for nextNode and PrevNode ,
    // and  2 poiners for sorted  , one node for graetNode , and lowNode with value
    private T value;
    private Node<T> nodeNext = null;
    private Node<T> nodePrev = null;
    private Node<T> nextNum = null;//with valu next(great)
    private Node<T> prevNum = null;//with valu prev(low)

    public Node ( T value ) {
        this.value = value;
    }

    public Node() {
    }

    // geter and Setter
    public T getValue() {
        return  value;
    }

    public Node<T> getNodeNext() {
        return nodeNext;
    }

    public Node<T> getNodePrev() {
        return nodePrev;
    }

    public Node<T> getNextNum() {
        return nextNum;
    }

    public Node<T> getPrevNum() {
        return prevNum;
    }

    public void setNodePrev(Node<T> nodePrev) {
        this.nodePrev = nodePrev;
    }

    public void setNodeNext(Node<T> nodeNext) {
        this.nodeNext = nodeNext;
    }

    public void setNextNum(Node<T> nextNum) {
        this.nextNum = nextNum;
    }

    public void setNumPrev(Node<T> prevNum) {
        this.prevNum = prevNum;
    }
}
