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
            inputList.add(scanner.nextLine().trim());
        }
        scanner.close();
        return  inputList;
    }

    public List<Integer> parseInputForInts(String pathToFile) throws FileNotFoundException {
        List<Integer> inputList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(pathToFile));
        scanner.useDelimiter(("\\D"));
        while (scanner.hasNextInt()) {
            inputList.add(scanner.nextInt());
        }
        scanner.close();
        return  inputList;
    }
}
