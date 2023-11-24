package racingcar.common.validate;

import java.util.Arrays;
import java.util.List;

public class Validate {
    public static void checkStringBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringCsvLengthNotExceeding(String inputCsv, int maxLength) {
        Arrays.asList(inputCsv.split(",")).forEach(input -> {
            checkStringLengthNotExceeding(input, maxLength);
        });
    }

    private static void checkStringLengthNotExceeding(String input, int maxLength) {
        if (input.length() >= maxLength) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkListDuplicates(List<String> input) {
        List<String> distinctList = input.stream().distinct().toList();
        if (input.size() != distinctList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringNonCharacter(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringPositiveInteger(String input) {
        if (Integer.parseInt(input) >= 0) {
            throw new IllegalArgumentException();
        }
    }
}
