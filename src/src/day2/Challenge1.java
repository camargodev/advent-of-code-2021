package day2;

import general.FileReader;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

public class Challenge1 extends Base {
    public static void main(String[] args) throws IOException {
        var lines = FileReader.read("day2/res/input.txt");
        var calculator = new CoordinateCalculator(consumerFor2dCoordinates());
        var coordinate = calculator.calculate(lines);
        var result = coordinate.getResult();
        System.out.println(result);
    }

    static Function<Command, Consumer<Coordinate>> consumerFor2dCoordinates() {
        return command -> switch (command.operation) {
            case FORWARD -> coordinate -> coordinate.x += command.value;
            case UP -> coordinate -> coordinate.y -= command.value;
            case DOWN -> coordinate -> coordinate.y += command.value;
        };
    }
}
