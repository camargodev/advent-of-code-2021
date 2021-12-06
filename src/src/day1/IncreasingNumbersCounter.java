package day1;

import java.util.List;

public class IncreasingNumbersCounter {
    private final int rangeLength;

    public IncreasingNumbersCounter(int rangeLength) {
        this.rangeLength = rangeLength;
    }

    public int count(List<Integer> numbers) {
        int increasing = 0;
        var currentSum = calculateInitialSum(numbers);
        for (var i = 0; i < numbers.size()-rangeLength; i++) {
            var lastSum = currentSum;
            currentSum = lastSum - numbers.get(i) + numbers.get(i+rangeLength);
            if (currentSum > lastSum) increasing += 1;
        }
        return increasing;
    }

    private int calculateInitialSum(List<Integer> numbers) {
        var sum = 0;
        for (int i = 0; i < rangeLength; i++) sum += numbers.get(i);
        return sum;
    }
}