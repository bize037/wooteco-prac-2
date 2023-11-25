package racingcar.common.validate;

import java.util.Arrays;
import java.util.List;
import racingcar.common.constants.Unit;

public class Validate {
    private static final String MATCHES_ONLY_INTEGER = "\\d+";
    private static final int POSITIVE_LOWER_BOUND = 0;

    public static void checkStringBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringCsvLengthNotExceeding(String inputCsv, int maxLength) {
        Arrays.asList(inputCsv.split(Unit.COMMA.getUnit())).forEach(input -> {
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
        if (!input.matches(MATCHES_ONLY_INTEGER)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkStringPositiveInteger(String input) {
        if (Integer.parseInt(input) >= POSITIVE_LOWER_BOUND) {
            throw new IllegalArgumentException();
        }
    }
}
