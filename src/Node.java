public class Node<T> {
    private T value;
    private Node<T> nodeNext = null;
    private Node<T> nodePrev = null;
    private Node<T> nextNum = null;
    private Node<T> prevNum = null;

    public Node ( T value ) {
        this.value = value;
    }

    public Node() {
    }

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

    public void setPrevNum(Node<T> prevNum) {
        this.prevNum = prevNum;
    }
}
