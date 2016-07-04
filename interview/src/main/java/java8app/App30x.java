package java8app;

import java.util.List;

import static java.util.Arrays.asList;

public class App30x {
    public static void main(String[] args) {
        List<String> arg0 = asList("1", "2", "3");
        List<String> arg1 = asList("A", "B");

//        mul(arg0, arg1).forEach(System.out::println);
    }

   /* private static <T> Stream<List<T>> mul(List<String> arg0, List<String> arg1) {
        return arg0.stream()
                .flatMap(new Function<Object, Stream>() {
                    public Stream apply(Object fst) {
                        return arg1.stream().map(new Function<T, List<T>>() {
                            public List<Object> apply(T snd) {
                                return Arrays.asList(fst, snd);
                            }
                        });
                    }
                });
    }*/
}
