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

    abstract public int Size();//listi chap@


    abstract public boolean IsEqual(FrencEinSHteinList<T> list);// stuguma erkus lister@ havasaren te che
    abstract public  FrencEinSHteinList<T> Copy(FrencEinSHteinList<T> list);// parametr tvac list@ veragruma mer listin  yev veradarcnume
    abstract  public  Node<T> Front(); // veradarcnuma head@
    abstract public  Node<T> Back();
    abstract public    boolean Empty();// veradarcnum list@ datarke te che
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
            Node<T> tmp = head;
            while (tmp != null) {
                System.out.print(tmp.getValue() + ", ");
                tmp = tmp.getNodeNext();
            }
        }
    }

    public void PrintSort(boolean sort) {
        if (sort) {
            Node<T> tmp = minNum;
            while (tmp != null) {
                System.out.println(tmp.getValue());
                tmp = tmp.getNextNum();
            }
        } else {
            Node<T> tmp = maxNum;
            while (tmp != null) {
                System.out.println(tmp.getValue());
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
            head.setNodePrev(node);
            node.setNodeNext(head);
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
    public FrencEinSHteinList<T> Copy(FrencEinSHteinList<T> list) {
        this.size = list.size;
        this.tail = list.tail;
        this.head = list.head;
        this.minNum = list.minNum;
        this.maxNum = list.maxNum;
        return  this;
    }

    @Override
    public int Size() {
        return size;
    }
    public Node<T> Front(){
        return head;
    }

    @Override
    public Node<T> Back() {
           return  tail;
    }

    @Override
    public boolean Empty() {
        return size == 0;
    }


}
