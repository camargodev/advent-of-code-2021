package general;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<String> read(String filename) throws IOException {
        var file = new File("./src/".concat(filename));
        var scanner = new Scanner(file);
        var lines = new ArrayList<String>();
        while (scanner.hasNext())
            lines.add(scanner.nextLine());
        scanner.close();
        return lines;
    }

}
