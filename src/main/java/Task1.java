import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        Random rnd = new Random();
        int[] ints = rnd.ints(1000, 1, 1000000).toArray();

        OptionalInt max = Arrays.stream(ints).max();
        if (max.isPresent()) {
            System.out.println("Max - " + max.getAsInt());
        } else System.out.println("Max - not found");

        int sum = Arrays.stream(ints)
                .filter(item -> item > 500000)
                .map(item -> item = item * 5)
                .map(item -> item - 150)
                .sum();

        System.out.println("Sum - " + sum);

        long count = Arrays.stream(ints)
                .filter(item -> item < 100000)
                .count();

        System.out.println("Count numbers < 100000 - " + count);
    }
}