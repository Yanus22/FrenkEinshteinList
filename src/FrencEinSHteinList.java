import javax.print.attribute.standard.NumberUp;

abstract class FrencEinShtein<T> {
    abstract public void Insert(Node<T> node);//stanuma node@ stugum listi size@ yev kanchum hamapatasxan funkcayaner@

    abstract protected void InsertHelperForSorted(Node<T> node);//ays  funkcyan kanchvuma inserti mejic yev katarum cucichneri katarum hamematum nodi valun yev listi ameamec yev amenapqr
    //valueov arjeqi elementneri het yev kanchum hamapatasxan funckyan

    abstract protected void InsertStart(Node<T> node); // avelcnum e elemnet@ erb size@ havasar = 0

    abstract protected void InsertMinNum(Node<T> node);// avelacnum e ayn depqum erb avlecnox nodi arjeq@ poqr e listi amenapoqr valueov Nodic

    abstract protected void InsertMaxNum(Node<T> node);// avelacnum e ayn depqum erb avlecnox nodi arjeq@ mec e listi amenamec valueov Nodic

    abstract protected void InsertTruePosition(Node<T> node);//avelacnum e ayn depqum yerb nodi valuen  ir arjeqov gtnvum e maxNodei valuei yev minNodi value mijakayqum

    abstract protected void InsertHelperDoubleLinkedList(Node<T> node);// avlacnum e vorpes doubleLiknked list

    abstract public void Print(boolean quue);//tpum e double linked list@ chisht hertakanutyamb yete  quue=true,hakarak depqum tpum e doubleLinked list@ hakarak hertakanutyamb

    abstract public void PrintSort(boolean sort);//yete sort = true apa tpume poqric mec ,falsei depqum mecic poqr

    abstract public void Insert(int index, Node<T> node);//avelacnum a doubleListumIndexov

    abstract public FrencEinSHteinList<T> Copy(FrencEinSHteinList<T> list);// parametr tvac list@ veragruma mer listin  yev veradarcnume c++i = operaotr@

    abstract public boolean Erase(int index, int count);//jnjuma trvac indexic sksac yev trvac qanakov

    abstract public Node<T> Front(); // veradarcnuma head@

    abstract public Node<T> Back();//veradarcnuma tail@

    abstract public void PushBack(Node<T> node);//avelacnuma verjic

    abstract public void PushFront(Node<T> node);// avelacnuma skzbic

    abstract public void EmplaceFront(int count);// avelacni skzbic   nshvac chapov deafult valyuov

    abstract public void PopBack();//jnjuma elment verjic

    abstract public void PopFront(); // jnjuma element skzbic

    abstract public void ReSize(int count);//sarquma trvac qanakov element yev avelcnum verjic

    abstract public void Merge(FrencEinSHteinList<T> list2);// list@ kpcnuma irar

    abstract public void Swap(FrencEinSHteinList<T> list1, FrencEinSHteinList<T> list2);//erkus lister@ poxuma  texerov;

    abstract public void Reverse();//double linked listi dirqer@ poxuma

    abstract public void Unique();// krknvox elementneric toxuma mek hat

    abstract public void Sort();//sortavoruma DoublLinked list@

    abstract public void Remove(int index);// jnjuma nod@ indexi ;

    abstract public void Remove(Node<T> node);//jnjuma trvac nodi hamapatasxanox valun

    abstract public void Clear(); //jnjel cucak@;

    abstract public boolean IsEqual(FrencEinSHteinList<T> list);// stuguma erkus lister@ havasaren te che  == C++i

    abstract public boolean IsNotEqual(FrencEinSHteinList<T> list);//stuguma erkus lister@  havasar chen

    abstract public boolean IsGreatOrNO(FrencEinSHteinList<T> list);//hertov elementner@ stuguma  > c++

    abstract public boolean IsGreatOrEqual(FrencEinSHteinList<T> list); // hertov elementner@ stugum >= c++

    abstract public boolean IsLowOrNo(FrencEinSHteinList<T> list); // hertov elementner@ stugum < c++

    abstract public boolean IsLowOrEqual(FrencEinSHteinList<T> list); // hertov elementner@ stugum <= c++

    abstract public int Size();//listi chap@

    abstract public boolean Empty();// veradarcnum list@ datarke te che

}


public class FrencEinSHteinList<T> extends FrencEinShtein<T> {
    private Node<T> head = new Node<>();
    private Node<T> maxNum = new Node<>();
    private Node<T> minNum = new Node<>();
    private Node<T> tail = new Node<>();
    private int size = 0;

    public FrencEinSHteinList() {
    }

    public void Insert(Node<T> node) {
        if (node == null) {
            throw new RuntimeException();
        } else if (size == 0) {
            InsertStart(node);
        } else {
            InsertHelperDoubleLinkedList(node);
            InsertHelperForSorted(node);
            size++;
        }

    }

    protected void InsertHelperForSorted(Node<T> node) {
        if (node.getValue() instanceof Number) {
            Double resultCompearMax;
            Double resultCompearMin;
            resultCompearMin = ((Number) node.getValue()).doubleValue() - ((Number) minNum.getValue()).doubleValue();
            resultCompearMax = ((Number) node.getValue()).doubleValue() - ((Number) maxNum.getValue()).doubleValue();
            if (resultCompearMax >= 0) {
                InsertMaxNum(node);//avelacnum a maxNodi verjic
            } else if (resultCompearMin <= 0) {
                InsertMinNum(node);// avelacnum a minNodi skzbic
            } else {
                InsertTruePosition(node);
            }
        } else {
            System.out.println("esim inch");
        }
    }

    protected void InsertStart(Node<T> node) {
        head = node;
        maxNum = node;
        minNum = node;
        tail = node;
        this.size = size + 1;
    }

    protected void InsertMaxNum(Node<T> node) {//avelcnuma averjic sortavorvacic;
        maxNum.setNextNum(node);
        node.setNumPrev(maxNum);
        maxNum = node;
    }

    protected void InsertMinNum(Node<T> node) {//avelacnum a skzbic sortavorvic
        minNum.setNumPrev(node);
        node.setNextNum(minNum);
        minNum = node;
    }

    protected void InsertTruePosition(Node<T> node) {
        //valeacnum a dnelov chisht tex@ mini u maxi aranq@
        Node<T> tmp = minNum;
        label:
        while (tmp.getNextNum() != null && (Double.parseDouble(tmp.getValue() + "") < Double.parseDouble(node.getValue() + ""))) {//araj uxarkel tmp vor chisht tex lini
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

    protected void InsertHelperDoubleLinkedList(Node<T> node) {
        tail.setNodeNext(node);
        node.setNodePrev(tail);
        tail = node;
    }

    public void Print(boolean quue) {
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

    public void PrintSort(boolean sort) {
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
    public void Insert(int index, Node<T> node) {
        if (index < 0 || index > size) {
            System.out.println("sxal indexov insert");
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

    public boolean IsEqual(FrencEinSHteinList<T> list) {
        if (Empty()){
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
    public boolean IsNotEqual(FrencEinSHteinList<T> list) {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        return !IsEqual(list);
    }

    @Override
    public boolean IsGreatOrNO(FrencEinSHteinList<T> list) {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();
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
    public boolean IsGreatOrEqual(FrencEinSHteinList<T> list) {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();
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
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();
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
    public boolean IsLowOrEqual(FrencEinSHteinList<T> list) {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if (size != list.Size()) {
            return false;
        } else {
            Node<T> tmp = head;
            Node<T> tmpList = list.Front();
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
    public FrencEinSHteinList<T> Copy(FrencEinSHteinList<T> list) {
        if (Empty()){
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
        if (Empty()){
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
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        return head;
    }

    @Override
    public Node<T> Back() {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        return tail;
    }

    @Override
    public void PushBack(Node<T> node) {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Insert(size, node);

    }

    @Override
    public void PushFront(Node<T> node) {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Insert(0, node);
    }

    @Override
    public void EmplaceFront(int count) {// count hat noda sarqum  deafult valuyov u skzbic avelacnum;
        if (Empty()){
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
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Remove(size - 1);

    }

    @Override
    public void PopFront() {
        if (Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Remove(0);

    }

    @Override
    public void ReSize(int count) {// count hat node avelcnuma verjic  nodi valuen deafult valuyov
        if (Empty()){
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
        if(list1.Empty() ) {
            System.out.println("list1 is empty");
            throw new RuntimeException();
        }
        if (list2.Empty()){
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
        if(Empty()){
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        if(size==1) {
            return;
        }

        Node<T> tmp = head;
        head = tail;
        tail = tmp;

        while (tmp != null) {
            Node<T> temp = tmp.getNodeNext();
            tmp.setNodeNext(tmp.getNodePrev());
            tmp.setNodePrev(temp);
            tmp = temp;
        }
    }


    @Override
    public void Unique() {//krknvox elementneric toxuma mi hat;
       if(Empty()) {
           System.out.println("list is empty");
           throw  new RuntimeException();
       }
        if(size == 1 ) {
            return;
        }
        Node<T> tmp = minNum;
        while (tmp != maxNum.getPrevNum()) {
            if(tmp.getValue() == tmp.getNextNum().getValue()){
                tmp = tmp.getNextNum();
                Remove(tmp.getPrevNum());
            }
            else {
                tmp = tmp.getNextNum();
            }
        }

    }

    @Override
    public void Sort() {
        if(Empty()) {
            System.out.println("list is empty");
            throw new RuntimeException();
        }
        Node<T> tmpMinNum = minNum;
        Node<T> tmpHead = head;
        while (tmpMinNum != null) {

        }
    }

    @Override
    public void Remove(int index) {
        if(Empty()){
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
    public void Clear() {
        while (size != 0) {
            Remove(0);
        }

    }

    @Override
    public boolean Empty() {
        return size == 0;
    }


    private void RemoveInSorte(T value) {//Sorti remove aysinq @ts value cucichneri uxum
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


