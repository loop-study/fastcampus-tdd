package tdd_basic_7;

import java.util.Arrays;

public class RefectorMain {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("데이터가 입력되지 않았습니다.");
        } else {
            System.out.println(getVariance(args));
        }
    }

    private static String getVariance(String[] args) {
        double[] s = parseArguments(args);
        double sum = calculateSum(s);
        double variance = sum / (s.length);
        return "variance = " + variance;
    }

    private static double calculateSum(double[] s) {
        return Arrays.stream(s)
                .sum();
    }

    private static double[] parseArguments(String[] args) {
        return Arrays.stream(args)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
