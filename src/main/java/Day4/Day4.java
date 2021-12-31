package Day4;

import Utils.InputParser;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

import static java.lang.Integer.parseInt;

public class Day4 {
    private InputParser inputParser = new InputParser();

    private List<String> WINNING_NUMBER_LIST = new ArrayList<>();
    private List<Integer> countCardsThatHaveWon = new ArrayList<>();



    public int getWinningScore(String bingoInputFilePath) throws FileNotFoundException {
        List<List<Map<String, Boolean>>> winningCard = getWinningBingoCards(bingoInputFilePath).get(0);
        AtomicInteger unmarkedSum = new AtomicInteger();

        List<Map<String, Boolean>>  allNumbersOnCard = new ArrayList<>();

        winningCard.forEach(allNumbersOnCard::addAll);

        allNumbersOnCard.forEach(number -> {
            if (number.containsValue(false)) {
                int numberValue = parseInt(Arrays.asList(number.toString().substring(1).split("=")).get(0));
                unmarkedSum.addAndGet(numberValue);
            }
        });

        return unmarkedSum.get() * parseInt(WINNING_NUMBER_LIST.get(0));
    }

    public int getLastWinningScore(String bingoInputFilePath) throws FileNotFoundException {
        List<List<List<Map<String, Boolean>>>> winningCards = getWinningBingoCards(bingoInputFilePath);
        List<List<Map<String, Boolean>>> lastWinningCard = winningCards.get(winningCards.size() - 1);
        AtomicInteger unmarkedSum = new AtomicInteger();

        List<Map<String, Boolean>>  allNumbersOnCard = new ArrayList<>();

        lastWinningCard.forEach(allNumbersOnCard::addAll);

        allNumbersOnCard.forEach(number -> {
            if (number.containsValue(false)) {
                int numberValue = parseInt(Arrays.asList(number.toString().substring(1).split("=")).get(0));
                unmarkedSum.addAndGet(numberValue);
            }
        });
        return unmarkedSum.get() * parseInt(WINNING_NUMBER_LIST.get(WINNING_NUMBER_LIST.size() - 1));
    }


    private List<List<List<Map<String, Boolean>>>> getWinningBingoCards(String bingoInputFilePath) throws FileNotFoundException {
        List<String> bingoInput = inputParser.parseInputForStringList(bingoInputFilePath);
        List<String> drawnNumbers = Arrays.asList(bingoInput.remove(0).split(","));

        List<String> bingoRows = bingoInput.stream().filter(b -> !b.isEmpty()).collect(Collectors.toList());

        AtomicReference<List<List<List<Map<String, Boolean>>>>> bingoCards = new AtomicReference<>(splitIntoCards(bingoRows));



        List<List<List<Map<String, Boolean>>>> winningCards = new ArrayList<>();
        AtomicBoolean foundBingo = new AtomicBoolean(false);
        drawnNumbers.forEach(number -> {
            while (winningCards.size() < bingoCards.get().size()) {
                bingoCards.set(markCards(number, bingoCards.get()));

                bingoCards.get().forEach(card -> {
                    if (checkForBingo(card)) {
                        foundBingo.set(true);
                        winningCards.add(card);
                    }
                });
                if (foundBingo.get()) { WINNING_NUMBER_LIST.add(number); }
            }
        });
        return winningCards;
    }

    private Boolean checkForBingo(List<List<Map<String, Boolean>>> card) {
        AtomicReference<Boolean> foundBingo = new AtomicReference<>(false);

        List<Map<String, Boolean>> column0 = new ArrayList<>();
        List<Map<String, Boolean>> column1 = new ArrayList<>();
        List<Map<String, Boolean>> column2 = new ArrayList<>();
        List<Map<String, Boolean>> column3 = new ArrayList<>();
        List<Map<String, Boolean>> column4 = new ArrayList<>();

        card.forEach(row -> {
            int numMarkedInRow = (int) row.stream().filter(number -> number.containsValue(true)).count();
            if (numMarkedInRow >= 5) {
                foundBingo.set(true);
            }
            IntStream.range(0, 4).forEach(i -> {
                if (i == 0) {
                    column0.add(row.get(i));
                } else if (i == 1) {
                    column1.add(row.get(i));
                } else if (i == 2) {
                    column2.add(row.get(i));
                } else if (i == 3) {
                    column3.add(row.get(i));
                } else {
                    column4.add(row.get(i));
                }
            });
        });

        if (foundBingo.get()) {
            return true;
        } else {
            List<List<Map<String, Boolean>>> columnCard = List.of(column0, column1, column2, column3, column4);
            columnCard.forEach(column -> {
                int numMarkedInColumn = (int) column.stream().filter(number -> number.containsValue(true)).count();
                if (numMarkedInColumn >= 5) {
                    foundBingo.set(true);
                }
            });
        }
        return foundBingo.get();
    }



    private List<List<List<Map<String, Boolean>>>> splitIntoCards(List<String> bingoRows) {
        List<List<String>> bingoCardChunks = Lists.partition(bingoRows, 5);

        List<List<List<Map<String, Boolean>>>> bingoCards = new ArrayList<>();

        bingoCardChunks.forEach(chunk -> {
            List<List<Map<String, Boolean>>> bingoCard = new ArrayList<>();
            chunk.forEach(row -> {
                List<String> numbers = Arrays.asList(row.split(" "));

                List<Map<String, Boolean>> rowInCard = new ArrayList<>();
                numbers.forEach(number -> rowInCard.add(Map.of(number, false)));

                bingoCard.add(rowInCard);
            });
            bingoCards.add(bingoCard);
        });
        return bingoCards;
    }

    private List<List<List<Map<String, Boolean>>>> markCards(String drawnNumber, List<List<List<Map<String, Boolean>>>> bingoCards) {
        List<List<List<Map<String, Boolean>>>> markedBingoCards = new ArrayList<>();
        bingoCards.forEach(card -> {
           List<List<Map<String, Boolean>>> markedBingoCard = new ArrayList<>();
           card.forEach(row -> {
               List<Map<String, Boolean>> markedRowInCard = new ArrayList<>();
               row.forEach(number -> {
                   if (number.containsKey(drawnNumber)) {
                       markedRowInCard.add(Map.of(drawnNumber, true));
                   } else {
                       markedRowInCard.add(number);
                   }

               });
               markedBingoCard.add(markedRowInCard);
           });
           markedBingoCards.add(markedBingoCard);
       });
        return markedBingoCards;
    }
}
