import javax.print.attribute.standard.NumberUp;

public class FrencEinSHteinList<T> {
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
            InsertHelperForSorted(node);
        }
    }

    private void InsertHelperForSorted(Node<T> node) {
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
                System.out.println("mej texic" + node.getValue());
                InsertTruePosition(node);
            }
        } else {
            System.out.println("esim inch");
        }
    }

    private void InsertStart(Node<T> node) {
        head = node;
        maxNum = node;
        minNum = node;
        tail = node;
        this.size = size + 1;
    }

    private void InsertMaxNum(Node<T> node) {//avelcnuma averjic sortavorvacic;

        maxNum.setNextNum(node);
        node.setPrevNum(maxNum);
        maxNum = node;
    }

    private void InsertMinNum(Node<T> node) {//avelacnum a skzbic sortavorvic
        minNum.setPrevNum(node);
        node.setNextNum(minNum);
        minNum = node;
    }

    private void InsertTruePosition(Node<T> node) { //valeacnum a dnelov chisht tex@ mini u maxi aranq@
        Node<T> tmp = minNum;
        Double l = Double.parseDouble(tmp.getValue() + " ");
        label:
        while (Double.parseDouble(tmp.getValue() + "") < Double.parseDouble(node.getValue() + "")) {//araj uxarkel tmp vor chisht tex lini
            if (tmp.getNextNum() != null && tmp.getNextNum().getNextNum() != null) {
                if (Float.parseFloat(tmp.getNextNum().getNextNum().getValue() + "") >= Double.parseDouble(node.getValue() + "")) {
                    break label;
                }
            }
            tmp = tmp.getNextNum();
            System.out.println(tmp);
        }
    }

    public void PrintForSort() {
        Node<T> tmp = minNum;
        System.out.println(tmp.getValue());
        System.out.println(tmp.getNextNum().getValue());
        System.out.println(tmp.getNextNum().getNextNum().getValue());
    }
}
