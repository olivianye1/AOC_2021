package Day3;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Day3 {
    InputParser inputParser = new InputParser();

    // Part 1
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

    private String toggleBinary(String binary) {
        return binary.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");
    }

    // Part 2
    public int getLifeSupportRating(String diagnosticReportFilePath) throws FileNotFoundException {
        List<String> binaries = inputParser.parseInputForStringList(diagnosticReportFilePath);
        return getOxygenGeneratorRating(binaries) * getCo2ScrubberRating(binaries);
    }

    public int getOxygenGeneratorRating(List<String> binaries) {

        if (binaries.size() == 0) {
            return 0;
        } else if (binaries.size() == 1){
            return parseInt(binaries.get(0), 2);
        } else {
            int bitsAnalyzed = 0;
            while (binaries.size() > 1) {
                int majorityThreshold = (int) Math.ceil(((double) binaries.size() / 2));
                int bitOfInterest = bitsAnalyzed;
                int oneCount = (int) binaries.stream().filter(b -> b.charAt(bitOfInterest) == '1').count();
                if (oneCount >= majorityThreshold) {
                    binaries = binaries.stream().filter(b -> b.charAt(bitOfInterest) == '1').collect(Collectors.toList());
                } else {
                    binaries = binaries.stream().filter(b -> b.charAt(bitOfInterest) == '0').collect(Collectors.toList());
                }
                bitsAnalyzed += 1;
            }
            return parseInt(binaries.get(0), 2);
        }
    }

    public int getCo2ScrubberRating(List<String> binaries) {
        if (binaries.size() == 0) {
            return 0;
        } else if (binaries.size() == 1){
            return parseInt(binaries.get(0), 2);
        } else {
            int bitsAnalyzed = 0;
            while (binaries.size() > 1) {
                int minorityThreshold = (int) Math.floor(((double) binaries.size() / 2));
                int bitOfInterest = bitsAnalyzed;
                int zeroCount = (int) binaries.stream().filter(b -> b.charAt(bitOfInterest) == '0').count();
                if (zeroCount <= minorityThreshold) {
                    binaries = binaries.stream().filter(b -> b.charAt(bitOfInterest) == '0').collect(Collectors.toList());
                } else {
                    binaries = binaries.stream().filter(b -> b.charAt(bitOfInterest) == '1').collect(Collectors.toList());
                }
                bitsAnalyzed += 1;
            }
            return parseInt(binaries.get(0), 2);
        }
    }
}

