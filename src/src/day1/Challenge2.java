package day1;

import general.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge2 {

    public static void main(String[] args) throws IOException {
        var lines = FileReader.read("day1/res/input.txt");
        var numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());
        var result = new IncreasingCounter().count(numbers);
        System.out.println(result);
    }

    static class IncreasingCounter {
        public int count(List<Integer> numbers) {
            int increasing = 0;
            var currentSum = calculateInitialSum(numbers);
            for (var i = 0; i < numbers.size()-3; i++) {
                var lastSum = currentSum;
                currentSum = lastSum - numbers.get(i) + numbers.get(i+3);
                if (currentSum > lastSum) increasing += 1;
            }
            return increasing;
        }

        private int calculateInitialSum(List<Integer> numbers) {
            return numbers.get(0) + numbers.get(1) + numbers.get(2);
        }


        private boolean isIncreasing(List<Integer> numbers, Integer pos) {
            return numbers.get(pos+1) > numbers.get(pos);
        }
    }




}
