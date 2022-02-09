package tasks.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaRandom {
    //13.7 p.168
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 7, 77, 89, 0);
        List<Integer> result = getRandomSubsetWithPredicate(list);
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.println(result.get(i));
        }
    }

    //1
    private static List<Integer> getRandomSubset(List<Integer> list) {
        List<Integer> subset = new ArrayList<>();
        Random random = new Random();
        for (int item : list) {
            //Flip coin
            if (random.nextBoolean()) {
                subset.add(item);
            }
        }
        return subset;
    }

    //2 add lambda
    private static List<Integer> getRandomSubsetWithLambda(List<Integer> list) {
        Random random = new Random();
        return list.stream().filter(k -> random.nextBoolean()).collect(Collectors.toList());
    }

    //3 add predicate
    private static List<Integer> getRandomSubsetWithPredicate(List<Integer> list) {
        Random random = new Random();
        Predicate<Object> flipCoin = o -> random.nextBoolean();
        return list.stream().filter(flipCoin).collect(Collectors.toList());
    }
}
