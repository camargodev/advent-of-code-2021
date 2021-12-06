package day2;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CoordinateCalculator {

     private final Function<Command, Consumer<Coordinate>> toOperations;

     public CoordinateCalculator(Function<Command, Consumer<Coordinate>> operations) {
         this.toOperations = operations;
     }

     public Coordinate calculate(List<String> commands) {var coordinate = new Coordinate();
        commands.stream().map(this::fromString).map(toOperations).forEach(coordinate::apply);
        return coordinate;
     }

     private Command fromString(String commandText) {
         String[] parts = commandText.split("\\s+");
         var operation = Operation.get(parts[0]);
         var value = Integer.parseInt(parts[1]);
         return new Command(operation, value);
     }

 static class Command {
     public Operation operation;
     public int value;
     private Command(Operation operation, int value) {
         this.operation = operation;
         this.value = value;
     }
 }

 enum Operation {
    FORWARD, UP, DOWN;
    static Operation get(String operationText) {
        return switch (operationText) {
            case "forward" -> FORWARD;
            case "up" -> UP;
            case "down" -> DOWN;
            default -> null;
        };
    }
 }
    static class Coordinate {
        public int x = 0, y = 0, aim = 0;
        public int getResult() { return x*y; }
        public void apply(Consumer<Coordinate> operation) { operation.accept(this); }
    }
}