package coding.kata;


public class StringCalculator {

    public StringCalculator() {
    }

    public int calculate(String numbers) {
        String[] numberTable = numbers.split(",");
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numberTable.length > 1) {
            return 2;
        }
        return Integer.parseInt(numbers);
    }
}
