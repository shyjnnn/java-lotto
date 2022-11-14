package lotto;

import java.util.List;


public class outputView {
    private enum Message {
        NUMBER_OF_LOTTO("개를 구매했습니다.");
        private final String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
    private static void printNumbers(List<Integer> numbers) {
            System.out.println(numbers);
    }
}
