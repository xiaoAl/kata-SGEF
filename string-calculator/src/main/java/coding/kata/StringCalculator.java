package coding.kata;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private final static String NEGATIVE_NOT_ALLOWED_EXCEPTION = "negatives not allowed ";
    private final static String DEFAULT_SEPARATORS = ",|\n";
    private final static int NEW_SEPARATOR_DELIMITER_LENGTH = 4;
    private final static String NEW_SEPARATOR_REGEX = "^/{2}.*\n.*";


    public StringCalculator() {
    }

    public int add(String stringValues) {
        if (stringValues.isEmpty()) {
            return 0;
        }
        if (stringValues.length() == 1) {
            return intValueFrom(stringValues);
        }
        return sum(computeStringNumberArray(stringValues));
    }

    private String[] computeStringNumberArray(String stringValues) {
        String[] stringNumberArray = getStringNumberArray(stringValues);
        checkForNegativeStringNumbers(stringNumberArray);
        return stringNumberArray;
    }

    private void checkForNegativeStringNumbers(String[] stringNumberArray) {
        List<String> negativeStringNumberList = Arrays.stream(stringNumberArray)
                .filter(stringNumber -> stringNumber.contains("-")).collect(Collectors.toList());
        throwExceptionIfNotEmpty(negativeStringNumberList);
    }

    private String[] getStringNumberArray(String stringValues) {
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

    private void throwExceptionIfNotEmpty(List<String> stringNumberList) {
        if (!stringNumberList.isEmpty()) {
            String customException = NEGATIVE_NOT_ALLOWED_EXCEPTION + stringNumberList.stream().collect(Collectors.joining(" "));
            throw new IllegalArgumentException(customException);
        }
    }

    private String extractStringNumberFrom(String stringNumbers, String newSeparator) {
        return stringNumbers.substring(newSeparator.length() + NEW_SEPARATOR_DELIMITER_LENGTH - 1);
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
