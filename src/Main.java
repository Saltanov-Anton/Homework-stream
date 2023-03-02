
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);

        printNumbers(list);

    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream
                .sorted(order)
                .collect(Collectors.toList());

        T min = !list.isEmpty() ? list.get(0) : null;
        T max = !list.isEmpty() ? list.get(list.size() - 1) : null;

        minMaxConsumer.accept(min, max);
    }

    public static void printNumbers(List<Integer> list) {
        list.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }

}