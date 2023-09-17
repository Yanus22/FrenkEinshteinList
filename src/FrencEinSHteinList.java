import javax.print.attribute.standard.NumberUp;

abstract class FrencEinShtein<T> {
    abstract public void Insert(Node<T> node);//this function insert element to list

    abstract protected void InsertHelperForSorted(Node<T> node); // This fuunction is helper for Insert funnction and this function setting pointer for node value

    abstract protected void InsertStart(Node<T> node); // This function Insert element where list size = 0; and this function called in Insert fauntiom

    abstract protected void InsertMinNum(Node<T> node);//This function for sorted  list , and this function add element sorted list in start,this fucntion will be called,when node value is low list low value

    abstract protected void InsertMaxNum(Node<T> node);// This function for sorted list ,and this function add element sorted list in end,this function will be called when node value is great list great value

    abstract protected void InsertTruePosition(Node<T> node);//This function for sorted list ,this function will be called when  node value great  list low element  and low list great element

    abstract protected void InsertHelperDoubleLinkedList(Node<T> node);// Insert logition for doubleLinkedlist

    abstract public void Print(boolean quue);//If   quue =true ,print doubleLinkedlist ,when quue = false,print reverse list

    abstract public void PrintSort(boolean sort);// If sort = true print SortedList,else print sortReverselist

    abstract public void Insert(int index, Node<T> node);//This is function add node in index

    abstract public FrencEinSHteinList<T> Copy(FrencEinSHteinList<T> list);// This function this = list, operator c++ (=)

    abstract public boolean Erase(int index, int count);//Remove element   from  index   to index + count

    abstract public Node<T> Front(); // Return head

    abstract public Node<T> Back();//Return tail
    abstract public void PushBack(Node<T> node);//Insert node in back DoubleLInkedlist

    abstract public void PushFront(Node<T> node);// Insert node in start oubleLInkedlist

    abstract public void EmplaceFront(int count);// Insert  in start, Count pieces Node in deafult value

    abstract public void PopBack();//Remov element in back DoubleLinkedList(head)

    abstract public void PopFront(); // Remove element in start DoubleLinkedList(tail)

    abstract public void ReSize(int count);// Insert  in back, Count pieces Node in deafult value

    abstract public void Merge(FrencEinSHteinList<T> list2);// This insert foreach element List2

    abstract public void Swap(FrencEinSHteinList<T> list1, FrencEinSHteinList<T> list2);// Swap list1 and list 2

    abstract public void Reverse();//Reverse DoubleLinkedList

    abstract public void Unique();// Remove Duplicate element

    abstract public void Sort();//Sorted list

    abstract public void Remove(int index);// Remove element in given index;

    abstract public void Remove(Node<T> node);//Remov elemetn in given node.value

    abstract public void Clear(); //Clear List
    // ==,>,>=,<,<= operators Function  is chek foreach element value in list

    abstract public boolean IsEqual(FrencEinSHteinList<T> list);// Chek to This. is equal          c++(==)

    abstract public boolean IsNotEqual(FrencEinSHteinList<T> list);// Chek to This. is not equal list

    abstract public boolean IsGreatOrNO(FrencEinSHteinList<T> list);//Chek This forEach element value  great list forEache elemennt value

    abstract public boolean IsGreatOrEqual(FrencEinSHteinList<T> list); //Chek This forEach element value  great or equal list forEache elemennt value

    abstract public boolean IsLowOrNo(FrencEinSHteinList<T> list); // //Chek This forEach element value  low list forEache elemennt value

    abstract public boolean IsLowOrEqual(FrencEinSHteinList<T> list); ////Chek This forEach element value  low or equal list forEache elemennt value

    abstract protected void RemoveInSorte(T value);//Remove  value in Sorted List and setting pointers

    abstract public int Size();//List size

    abstract public boolean Empty();// List is empty ?

}


public class FrencEinSHteinList<T> extends FrencEinShtein<T> {   // Extends abstract class for  implementetion  abstract method
    private Node<T> head = new Node<>();
    private Node<T> maxNum = new Node<>();
    private Node<T> minNum = new Node<>();
    private Node<T> tail = new Node<>();
    private int size = 0;

    public FrencEinSHteinList() {
    }

    @Override
    public void Insert(Node<T> node) {  //  can not Insert  null node
        if (node == null) {
            throw new RuntimeException();
        } else if (size == 0) {
            InsertStart(node);
        } else {
            InsertHelperDoubleLinkedList(node);// Insert node with DoubleLinkedLIst
            InsertHelperForSorted(node);//Insert node with Sorted List
            size++;
        }

    }

    @Override
    protected void InsertHelperForSorted(Node<T> node) { // helper for sorted   Function
        if (node.getValue() instanceof Number) {
            Double resultCompearMax;
            Double resultCompearMin;
            resultCompearMin = ((Number) node.getValue()).doubleValue() - ((Number) minNum.getValue()).doubleValue(); // Compear node value and low element for list
            resultCompearMax = ((Number) node.getValue()).doubleValue() - ((Number) maxNum.getValue()).doubleValue();// Compear node valuue and Great element for list
            if (resultCompearMax >= 0) {
                InsertMaxNum(node);//Insert end in Sorted list
            } else if (resultCompearMin <= 0) {
                InsertMinNum(node);// Insert start in Soted list
            } else {
                InsertTruePosition(node);// Insert  node in [min - max] position
            }
        } else {
            System.out.println("I dont know"); // this List  with Number value
        }
    }

    @Override
    protected void InsertStart(Node<T> node) {//Insert start for DoubleLinked list and Sorted list
        head = node;
        maxNum = node;
        minNum = node;
        tail = node;
        this.size = size + 1;
    }

    @Override
    protected void InsertMaxNum(Node<T> node) {// Insert end sort list
        maxNum.setNextNum(node);
        node.setNumPrev(maxNum);
        maxNum = node;
    }

    @Override
    protected void InsertMinNum(Node<T> node) {//avelacnum a skzbic sortavorvic
        minNum.setNumPrev(node);
        node.setNextNum(minNum);
        minNum = node;
    }

    @Override
    protected void InsertTruePosition(Node<T> node) {// sorted list in [min-max] position
        Node<T> tmp = minNum;
        label: while (tmp.getNextNum() != null && (Double.parseDouble(tmp.getValue() + "") < Double.parseDouble(node.getValue() + ""))) { // search true poition
            if (Double.parseDouble(tmp.getNextNum().getValue() + "") >= Double.parseDouble(node.getValue() + "")) {
                break label;
            }
            tmp = tmp.getNextNum();
        }
        Node<T> tmp2 = tmp.getNextNum();
        node.setNextNum(tmp2);
        node.setNumPrev(tmp);
        tmp2.setNumPrev(node);
        tmp.setNextNum(node);
    }

    @Override
    protected void InsertHelperDoubleLinkedList(Node<T> node) { //
        tail.setNodeNext(node);
        node.setNodePrev(tail);
        tail = node;
    }

    @Override
    public void Print(boolean quue) { // print DoubleLinedList
        if (size == 0) {
            System.out.println("list is empty");
        } else {
            if (quue) {
                Node<T> tmp = head;
                while (tmp != null) {
                    System.out.print(tmp.getValue() + ", ");
                    tmp = tmp.getNodeNext();
                }
            } else {
                Node<T> tmp = tail;
                while (tmp != null) {
                    System.out.print(tmp.getValue() + ",");
                    tmp = tmp.getNodePrev();
                }
            }
        }
    }

    @Override
    public void PrintSort(boolean sort) { // Print Sorted List
        if (sort) {
            Node<T> tmp = minNum;
            while (tmp != null) {
                System.out.print(tmp.getValue() + " ,");
                tmp = tmp.getNextNum();
            }
        } else {
            Node<T> tmp = maxNum;
            while (tmp != null) {
                System.out.print(tmp.getValue() + " ,");
                tmp = tmp.getPrevNum();
            }
        }
    }

    @Override
    public void Insert(int index, Node<T> node) { // Insert node in index
        if (index < 0 || index > size) {
            System.out.println("ileag index");
            throw new RuntimeException();
        } else if (index == 0) {
            node.setNodePrev(null);
            node.setNodeNext(head);
            head.setNodePrev(node);
            head = node;

        } else if (index == size) {
            tail.setNodeNext(node);
            node.setNodePrev(tail);
            tail = node;
        } else {
            Node<T> tmp = head;
            while (index > 0) {
                tmp = tmp.getNodeNext();
                index--;
            }
            Node<T> tmp2 = tmp.getNodePrev();
            tmp2.setNodeNext(node);
            node.setNodePrev(tmp2);
            node.setNodeNext(tmp);
            tmp.setNodePrev(node);
        }
        InsertHelperForSorted(node);
        size++;
    }

    @Override
    public boolean IsEqual(FrencEinSHteinList<T> list) { // compear ForEache elemetn this and list
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        }
        Node<T> headThis = head;
        Node<T> headList = list.head;

        while (headThis != null) {
            if (headThis.getValue() == headList.getValue()) {
                headList = headList.getNodeNext();
                headThis = headThis.getNodeNext();
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean IsNotEqual(FrencEinSHteinList<T> list) { // compear ForEache elemetn this and list
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        return !IsEqual(list);
    }

    @Override
    public boolean IsGreatOrNO(FrencEinSHteinList<T> list) { // compear ForEache elemetn this and list
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();// list head
            while (tmp != null && tmpList != null) {
                if (Double.parseDouble(tmp.getValue() + "") > Double.parseDouble(tmpList.getValue() + "")) {
                    tmp = tmp.getNodeNext();
                    tmpList = tmpList.getNodeNext();
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public boolean IsGreatOrEqual(FrencEinSHteinList<T> list) {// compear ForEache elemetn this and list
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();//  list head
            while (tmp != null && tmpList != null) {
                if (Double.parseDouble(tmp.getValue() + "") >= Double.parseDouble(tmpList.getValue() + "")) {
                    tmp = tmp.getNodeNext();
                    tmpList = tmpList.getNodeNext();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean IsLowOrNo(FrencEinSHteinList<T> list) {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();//list head
            while (tmp != null && tmpList != null) {
                if (Double.parseDouble(tmp.getValue() + "") < Double.parseDouble(tmpList.getValue() + "")) {
                    tmp = tmp.getNodeNext();
                    tmpList = tmpList.getNodeNext();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean IsLowOrEqual(FrencEinSHteinList<T> list) {  // compear ForEache elemetn this and list
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();//list head
            while (tmp != null && tmpList != null) {
                if (Double.parseDouble(tmp.getValue() + "") <= Double.parseDouble(tmpList.getValue() + "")) {
                    tmp = tmp.getNodeNext();
                    tmpList = tmpList.getNodeNext();
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public FrencEinSHteinList<T> Copy(FrencEinSHteinList<T> list) { //C ++ (=) operator
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        while (size != 0) {//jnjelu hamar noder@
            Remove(0);
        }
        this.head = list.head;
        this.tail = list.tail;
        this.minNum = list.minNum;
        this.maxNum = list.maxNum;
        this.size = list.size;
        return this;
    }

    @Override
    public boolean Erase(int index, int count) {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (index >= size || index < 0 || count < 0 || (index + count) > size) {
            throw new RuntimeException();
        }
        for (int i = 0; i < count; i++) {
            Remove(index);
        }

        return true;
    }

    @Override
    public int Size() {
        return size;
    }

    public Node<T> Front() {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        return head;
    }

    @Override
    public Node<T> Back() {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        return tail;
    }

    @Override
    public void PushBack(Node<T> node) {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Insert(size, node);

    }

    @Override
    public void PushFront(Node<T> node) {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Insert(0, node);
    }

    @Override
    public void EmplaceFront(int count) {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (count <= 0) {
            System.out.println("sount is not valid");
            throw new RuntimeException();
        } else {
            for (int i = 1; i < count + 1; i++) {
                if (head.getValue() instanceof Number) {
                    Node<T> node = (Node<T>) new Node<>(0);
                    Insert(0, node);
                } else {
                    Node<T> node = new Node<>();
                    Insert(0, node);
                }
            }
        }
    }

    @Override
    public void PopBack() {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Remove(size - 1);

    }

    @Override
    public void PopFront() {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Remove(0);

    }

    @Override
    public void ReSize(int count) {// count hat node avelcnuma verjic  nodi valuen deafult valuyov
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (count <= 0) {
            System.out.println("count is not valid");
            throw new RuntimeException();
        } else {
            for (int i = 1; i < count + 1; i++) {
                if (head.getValue() instanceof Number) {
                    Node<T> node = (Node<T>) new Node<>(0);
                    Insert(size, node);
                } else {
                    Node<T> node = new Node<>();
                    Insert(size, node);
                }
            }
        }
    }

    @Override
    public void Merge(FrencEinSHteinList<T> list2) {
        Node<T> tmp = list2.head;
        while (tmp != null) {
            Insert(tmp);
            tmp = tmp.getNodeNext();
        }

    }

    @Override
    public void Swap(FrencEinSHteinList<T> list1, FrencEinSHteinList<T> list2) {
        if (list1.Empty()) {
            System.out.println("list1 is empty");
            throw new RuntimeException();
        }
        if (list2.Empty()) {
            System.out.println("list2 is empty");
            throw new RuntimeException();
        }
        Node<T> tmpHead = list1.head;
        Node<T> tmpTail = list1.tail;
        Node<T> tmpMinNum = list1.minNum;
        Node<T> tmpMaxNum = list1.maxNum;
        int tmpSize = list1.size;
        list1.head = list2.head;
        list1.tail = list2.tail;
        list1.minNum = list2.minNum;
        list1.maxNum = list2.maxNum;
        list1.size = list2.size;
        list2.head = tmpHead;
        list2.tail = tmpTail;
        list2.minNum = tmpMinNum;
        list2.maxNum = tmpMaxNum;
        list2.size = tmpSize;
    }

    @Override
    public void Reverse() {
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size == 1) {
            return;
        }

        Node<T> tmp = head;
        head = tail;
        tail = tmp;

        while (tmp != null) {
            Node<T> temForTemp= tmp.getNodeNext();
            tmp.setNodeNext(tmp.getNodePrev());
            tmp.setNodePrev(temForTemp);
            tmp = temForTemp;
        }
    }


    @Override
    public void Unique() {//krknvox elementneric toxuma mi hat;
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size == 1) {
            return;
        }
        Node<T> tmp = minNum;
        while (tmp != maxNum.getPrevNum()) {
            if (tmp.getValue() == tmp.getNextNum().getValue()) {
                tmp = tmp.getNextNum();
                Remove(tmp.getPrevNum());
            } else {
                tmp = tmp.getNextNum();
            }
        }

    }

    @Override
    public void Sort() { //Double linked listi sortavorum
        if (Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Node<T> tmpMinNum = minNum;
         while (tmpMinNum != null)  {
             tmpMinNum.setNodeNext(tmpMinNum.getNextNum());
             tmpMinNum.setNodePrev(tmpMinNum.getPrevNum());
             tmpMinNum =tmpMinNum.getNodeNext();
         }
         head =minNum;
         tail = maxNum;

    }

    @Override
    public void Remove(int index) { //remove element with Index
        if (Empty()) {
            System.out.println("list is emopty");
            throw new RuntimeException();
        }

        if (size == 1) {
            head = null;
            minNum = null;
            maxNum = null;
            tail = null;
            size--;
            return;
        }
        T valueForRemovSorted = null;
        if (index < 0 || index >= size) throw new RuntimeException();
        else if (index == 0) {
            valueForRemovSorted = head.getValue();
            Node<T> tmp = head;
            head = head.getNodeNext();
            tmp.setNodeNext(null);
            head.setNodePrev(null);
        } else if (index == size - 1) {
            valueForRemovSorted = tail.getValue();
            Node<T> tmp = tail;
            tail = tmp.getNodePrev();
            tmp.setNodePrev(null);
            tail.setNodeNext(null);
        } else {
            Node<T> tmp = head;
            while (index != 0) {
                tmp = tmp.getNodeNext();
                index--;
            }
            valueForRemovSorted = tmp.getValue();
            Node<T> tmp2 = tmp.getNodePrev();
            tmp2.setNodeNext(tmp.getNodeNext());
            tmp.getNodeNext().setNodePrev(tmp2);
        }
        RemoveInSorte(valueForRemovSorted);
        size--;

    }

    @Override
    public void Remove(Node<T> node) {
        int i = 0;
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.getValue() == node.getValue()) {
                Remove(i);
                return;
            } else if (tmp == tail && tmp.getValue() != node.getValue()) {
                return;
            } else {
                tmp = tmp.getNodeNext();
                i++;
            }
        }
    }


    @Override
    public void Clear() {//Clear List
        while (size != 0) {
            Remove(0);
        }

    }

    @Override
    public boolean Empty() {
        return size == 0;
    }

    @Override
    protected void RemoveInSorte(T value) {//Remove Funtion for Sorted list
        Node<T> tmp = null;
        if (minNum.getValue() == value) {
            tmp = minNum;
            minNum = minNum.getNextNum();
            tmp.setNextNum(null);
            minNum.setNumPrev(null);
        } else if (maxNum.getValue() == value) {
            tmp = maxNum;
            maxNum = maxNum.getPrevNum();
            tmp.setNumPrev(null);
            maxNum.setNextNum(null);
        } else {
            tmp = minNum;
            while (tmp.getValue() != value) {
                tmp = tmp.getNextNum();
            }
            Node<T> tmp2 = tmp.getPrevNum();
            Node<T> tmp3 = tmp.getNextNum();
            tmp2.setNextNum(tmp3);
            tmp3.setNumPrev(tmp2);
            tmp.setNumPrev(null);
            tmp.setNextNum(null);
        }
    }


}


