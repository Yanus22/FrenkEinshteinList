public class Main {
    public static void main(String[] args) {
         FrencEinSHteinList<Integer> list = new FrencEinSHteinList<>();
         FrencEinSHteinList<Integer> list2 = new FrencEinSHteinList<>();
        for (int i = 0;i < 10; i++) {

            list.Insert(new Node<>(i*3));
            list2.Insert(new Node<>(i*3));
        }

        System.out.println(list2.IsEqual(list));


    }
}