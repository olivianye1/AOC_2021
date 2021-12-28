package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    public List<String> parseInputForStringList(String pathToFile) throws FileNotFoundException {
        List<String> inputList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(pathToFile));
        while (scanner.hasNextLine()) {
            inputList.add(scanner.nextLine());
        }
        scanner.close();
        return  inputList;
    }
}
