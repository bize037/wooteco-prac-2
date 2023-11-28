package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceCountTest {
    @DisplayName("문자열로 들어온 이동 횟수가 int 형식으로 저장되는가")
    @ValueSource(strings = {"2", "6", "10"})
    @ParameterizedTest
    void saveRaceCountStringToRaceCountInteger(String inputRaceCount) {
        RaceCount raceCount = new RaceCount(inputRaceCount);
        assertThat(raceCount.getRaceCount()).isEqualTo(Integer.parseInt(inputRaceCount));
    }

    @DisplayName("공백이 입력된 경우 예외 처리 되는가")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateRaceCountNotBlank(String inputRaceCount) {
        assertThatThrownBy(() -> new RaceCount(inputRaceCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자가 입력된 경우 예외 처리 되는가")
    @ValueSource(strings = {"1asdf", "pass5", "a"})
    @ParameterizedTest
    void validateRaceCountNotCharacter(String inputRaceCount) {
        assertThatThrownBy(() -> new RaceCount(inputRaceCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양의 정수가 아닌 숫자가 입력된 경우 예외 처리 되는가")
    @ValueSource(strings = {"0", "-1", "1.5"})
    @ParameterizedTest
    void validateRaceCountPositiveInteger(String inputRaceCount) {
        assertThatThrownBy(() -> new RaceCount(inputRaceCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
