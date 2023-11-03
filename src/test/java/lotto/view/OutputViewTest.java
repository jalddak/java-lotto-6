package lotto.view;

import static lotto.view.OutputView.printSystemMessage;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("출력 (구매 금액 입력 안내 문구)")
    @Test
    void 출력테스트_printSystemMessage() {
        //given
        String expect = "구입금액을 입력해 주세요.\n";

        //when
        printSystemMessage(SystemMessage.ASK_MONEY);

        //then
        assertThat(output.toString()).isEqualTo(expect);
    }
}
