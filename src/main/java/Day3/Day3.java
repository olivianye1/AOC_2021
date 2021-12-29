package Day3;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Day3 {
    InputParser inputParser = new InputParser();

    public int getPowerConsumption(String diagnosticReportFilePath) throws FileNotFoundException {
        List<String> binaries = inputParser.parseInputForStringList(diagnosticReportFilePath);

        if (binaries.size() == 0) {
            return 0;
        } else if (binaries.size() == 1){
            return parseInt(binaries.get(0), 2) * parseInt(toggleBinary(binaries.get(0)), 2);
        } else {
            int majorityThreshold = (binaries.size() / 2) + 1;
            int numBits = binaries.get(0).length();
            StringBuilder gammaRateBuilder = new StringBuilder();

            int bitsAnalyzed = 0;
            while (bitsAnalyzed < numBits) {
                int bitOfInterest = bitsAnalyzed;
                int zeroCount = (int) binaries.stream().filter(b -> b.charAt(bitOfInterest) == '0').count();
                if (zeroCount >= majorityThreshold) {
                    gammaRateBuilder.append("0");
                } else {
                    gammaRateBuilder.append("1");
                }
                bitsAnalyzed += 1;
            }
            String gammaRate = gammaRateBuilder.toString();
            return parseInt(gammaRate, 2) * parseInt(toggleBinary(gammaRate), 2);
        }
    }

    private String toggleBinary (String binary) {
        return binary.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
    }
}

