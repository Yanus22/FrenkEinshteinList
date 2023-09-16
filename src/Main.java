import java.util.List;

public class Main {
    public static void main(String[] args) {
        FrencEinSHteinList<Integer> list = new FrencEinSHteinList<>();

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) list.Insert(new Node<>(i * 2));
            else list.Insert(new Node<>(i * -3));
        }
    }
}