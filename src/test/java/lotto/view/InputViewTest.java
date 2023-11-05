package lotto.view;

import static lotto.view.ErrorMessage.NOT_NUMBER;
import static lotto.view.InputView.inputIntegerData;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @AfterEach
    public void closeConsole() {
        Console.close();
    }

    @DisplayName("long 형 자료 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1423", "412312", "123123", "223123", "213123", "2147483647", "9223372036854775807"})
    void 정상테스트_inputIntegerData(String input) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String expect = input;
        //when
        String result = inputIntegerData();
        //then
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("long 형 자료로 변환되지 않으면 예외발생")
    @ParameterizedTest
    @ValueSource(strings = {" 1423", "412312 ", "123 123", "223a123", "a213123", "9223372036854775808"})
    void 예외테스트_inputStrangeData(String input) {
        //given
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        //when
        assertThatThrownBy(() -> inputIntegerData())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER.getMessage());
    }
}
