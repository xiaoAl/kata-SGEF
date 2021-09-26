package coding.kata;


public class StringCalculator {

    public StringCalculator() {
    }

    public int calculate(String numbers) {
        String[] numberTable = numbers.split(",");
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numberTable.length > 1) { // j'aurai pu mettre ici == 2, au moins au début
            return Integer.parseInt(numberTable[0]) + Integer.parseInt(numberTable[1]);
        }
        return Integer.parseInt(numbers);
    }
}
