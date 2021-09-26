package coding.kata;


import java.util.Arrays;

public class StringCalculator {

    private final static String DEFAULT_SEPARATORS = ",|\n";

    private final static String NEW_SEPARATOR_REGEX = "^/{2}.*\n.*";

    public StringCalculator() {
    }

    public int calculate(String stringValues) {

        String[] stringNumberArray;

        stringNumberArray = computeStringNumberArray(stringValues);

        if (stringValues.isEmpty()) {
            return 0;
        }

        if (stringNumberArray.length > 1) {
            return sum(stringNumberArray);
        }
        return intValueFrom(stringValues);
    }

    private String[] computeStringNumberArray(String stringValues) {
        String[] stringNumberArray;
        if (stringValues.matches(NEW_SEPARATOR_REGEX)) {
            String newSeparator = extractNewSeparatorFrom(stringValues);
            String newStringNumber = extractStringNumberFrom(stringValues, newSeparator);
            stringNumberArray = newStringNumber.split(newSeparator);
        } else {
            stringNumberArray = stringValues.split(DEFAULT_SEPARATORS);
        }
        return stringNumberArray;
    }

    private String extractStringNumberFrom(String stringNumbers, String newSeparator) {
        return stringNumbers.substring(newSeparator.length() + 4 - 1);
    }

    private String extractNewSeparatorFrom(String stringNumbers) {
        return stringNumbers.split("\n")[0].split("//")[1];
    }

    private int sum(String[] stringNumberArray) {
        return Arrays.stream(stringNumberArray).map(this::intValueFrom).reduce(0, Integer::sum);
    }

    private int intValueFrom(String stringValue) {
        return Integer.parseInt(stringValue);
    }
}
