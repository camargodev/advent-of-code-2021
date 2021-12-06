package day1;

import general.FileReader;

import java.io.IOException;
import java.util.stream.Collectors;

public class Challenge1 {
    public static void main(String[] args) throws IOException {
        var lines = FileReader.read("day1/res/input.txt");
        var numbers = lines.stream().map(Integer::parseInt).collect(Collectors.toList());
        var result = new IncreasingNumbersCounter(1).count(numbers);
        System.out.println(result);
    }
}
