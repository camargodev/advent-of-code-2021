package day1;

import general.FileReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Challenge1 {

    public static void main(String[] args) throws IOException {
        var lines = FileReader.read("day1/res/input.txt");
        var numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());
        var result = new IncreasingCounter().count(numbers);
        System.out.println(result);
    }

    static class IncreasingCounter {
        public int count(List<Integer> numbers) {
            int increasing = 0;
            for (var i = 0; i < numbers.size()-1; i++)
                if (isIncreasing(numbers, i)) increasing += 1;
            return increasing;
        }
        private boolean isIncreasing(List<Integer> numbers, Integer pos) {
            return numbers.get(pos+1) > numbers.get(pos);
        }
    }




}
