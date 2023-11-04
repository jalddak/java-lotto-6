package lotto.view;

public class OutputView {
    public static void printSystemMessage(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printNumOfTickets(int numOfTickets) {
        System.out.println("\n" + numOfTickets + "개를 구매했습니다.");
    }
}
