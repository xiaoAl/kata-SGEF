package coding.kata;


public class StringCalculator {

    private final static String COMMA_SEPARATOR = ",";

    public StringCalculator() {
    }

    public int calculate(String stringNumbers) {
        String[] stringNumberTable = stringNumbers.split(COMMA_SEPARATOR);
        if (stringNumbers.isEmpty()) {
            return 0;
        }
        if (stringNumberTable.length > 1) { // j'aurai pu mettre ici == 2, au moins au début
            return from(stringNumberTable[0]) + from(stringNumberTable[1]);
        }
        return from(stringNumbers);
    }

    private int from(String stringValue) {
        return Integer.parseInt(stringValue);
    }
}
