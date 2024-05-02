package demo02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args) {
        int[] intArray = {9, 5, 7, 3, 4, 10, 35};
        double[] doubleArray = {9.6, 5.4, 7.1, 3.23, 4.9, 10.0, 35.7};

        // 第一種方式
        for (int i = 0; i < intArray.length; i++) {
            if (i != 0) System.out.print(", ");
            System.out.print(intArray[i]);
        }

        System.out.println();
        // 第二種方式
        // Arrays API
        System.out.println(Arrays.toString(intArray));

        // 第三種方式
        Arrays.stream(intArray).forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // 第四種方式
        IntStream.of(intArray).forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // doubleArray ========================
        System.out.println("====== doubleArray ==========");
        DoubleStream.of(doubleArray)
                .forEach(d -> System.out.print(d + ", "));

        System.out.println();
        // 統計 - sum
        int sum = Arrays.stream(intArray).sum();
        System.out.println("加總：" + sum);
        // 統計 - average
        double avg = Arrays.stream(intArray).average().getAsDouble();
        System.out.println("平均值：" + avg);
        System.out.printf("平均值：%.4f\n", avg);
        // 統計 - min
        Arrays.stream(intArray).min().ifPresent(System.out::println);
        int min = Arrays.stream(intArray).min().getAsInt();
        System.out.println("最小值：" + min);
        // 統計 - max
        Arrays.stream(intArray).max().ifPresent(System.out::println);
        int max = Arrays.stream(intArray).max().getAsInt();
        System.out.println("最大值：" + max);

        // 統計 -> sum, avg, min, max
        IntSummaryStatistics stat = Arrays.stream(intArray).summaryStatistics();
        System.out.println(stat);
        System.out.println(stat.getSum());
        System.out.println(stat.getAverage());
        System.out.println(stat.getMin());
        System.out.println(stat.getMax());
    }
}
