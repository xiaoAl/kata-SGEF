package coding.kata;


import java.util.Arrays;

public class StringCalculator {

    private final static String SEPARATORS = ",|\n";

    public StringCalculator() {
    }

    public int calculate(String stringNumbers) {
        String[] stringNumberArray = stringNumbers.split(SEPARATORS);
        if (stringNumbers.isEmpty()) {
            return 0;
        }
        if (stringNumberArray.length > 1) {
            return sum(stringNumberArray);
        }
        return intValueFrom(stringNumbers);
    }

    private int sum(String[] stringNumberArray) {
        return Arrays.stream(stringNumberArray).map(this::intValueFrom).reduce(0, Integer::sum);
    }

    private int intValueFrom(String stringValue) {
        return Integer.parseInt(stringValue);
    }
}
