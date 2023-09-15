import java.util.List;

public class Main {
    public static void main(String[] args) {
        FrencEinSHteinList<Integer> list = new FrencEinSHteinList<>();
        FrencEinSHteinList<Integer> list1 = new FrencEinSHteinList<>();
        FrencEinSHteinList<Integer> tmp = new FrencEinSHteinList<>();

        for (int i = 1; i < 10; i++) {
            list.Insert(new Node<>(i * 2));
        }
        list.Insert(list.Size(),new Node<>(2));
        list.Insert(list.Size(),new Node<>(2));
        list.Insert(list.Size(),new Node<>(2));
        list.Insert(list.Size(),new Node<>(2));
        list.Insert(2,new Node<>(2));
        list.Insert(3,new Node<>(4));
        list.Insert(2,new Node<>(5));
        list.Insert(2,new Node<>(8));
        list.Insert(2,new Node<>(10));

        list.Print(true);
        list.Unique();
        System.out.println();
        list.Print(true);
    }
}