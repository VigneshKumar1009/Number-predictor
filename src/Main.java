import java.util.ArrayList;
import java.util.List;

class NumberPredictor {
    private List<Integer> fibonacciNumbers;

    public NumberPredictor() {
        generateFibonacciNumbers();
    }

    private void generateFibonacciNumbers() {
        fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(0);
        fibonacciNumbers.add(1);

        int fib1 = 0;
        int fib2 = 1;
        while (fib2 < 100) {  // You can adjust the limit based on your needs
            int nextFib = fib1 + fib2;
            fibonacciNumbers.add(nextFib);
            fib1 = fib2;
            fib2 = nextFib;
        }
    }

    public int predictLuckyNumber(int dateOfBirth) {
        int nearestFibonacci = findNearestFibonacci(dateOfBirth);
        return nearestFibonacci;
    }

    private int findNearestFibonacci(int num) {
        int nearestFib = fibonacciNumbers.get(0);
        int minDiff = Math.abs(num - nearestFib);

        for (int fibonacci : fibonacciNumbers) {
            int diff = Math.abs(num - fibonacci);
            if (diff < minDiff) {
                minDiff = diff;
                nearestFib = fibonacci;
            }
        }
        return nearestFib;
    }
}

class LuckyNumberPredictor {
    private NumberPredictor numberPredictor;

    public LuckyNumberPredictor() {
        numberPredictor = new NumberPredictor();
    }

    public int getLuckyNumber(int dateOfBirth) {
        return numberPredictor.predictLuckyNumber(dateOfBirth);
    }
}

public class Main {
    public static void main(String[] args) {
        int dateOfBirth = 10;  // Replace this with the actual date of birth
        LuckyNumberPredictor predictor = new LuckyNumberPredictor();
        int luckyNumber = predictor.getLuckyNumber(dateOfBirth);
        System.out.println("Your lucky number is: " + luckyNumber);
    }
}
