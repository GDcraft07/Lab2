import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    static PrintStream out = new PrintStream(System.out);
    static Scanner in = new Scanner(System.in);

    static long [] double_to_int(double number) {
        long [] answer = new long[2];
        answer[1] = -1;
        while (number * Math.pow(100, answer[1]) != answer[0] && number * Math.pow(100, answer[1]) != answer[0] * 10) {
            answer[1]++;
            answer[0] = (long) (number * Math.pow(100, answer[1]));
        }

        return answer;
    }


    static double sqrt(double double_number, int count_accuracy) {
        long [] int_number = double_to_int(double_number);
        long number = int_number[0];
        long divider = int_number[1];
        double accuracy = 1 / Math.pow(10, count_accuracy);
        boolean flag = true;
        double step = number;
        double answer = 0;

        while (flag) {
            answer = 0.5 * (step + number / step);

            if (step - answer < accuracy) {
                flag = false;
            }

            else {
                step = answer;
            }
        }

        return answer / Math.pow(10, divider);
    }

    public static void main(String[] args) {
        double number = in.nextDouble();
        int accuracy = 10;
        out.println(Math.sqrt(number));
        out.println(sqrt(number, accuracy));
    }
}