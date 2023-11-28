package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceCountTest {
    @DisplayName("문자열로 들어온 이동 횟수가 int 형식으로 저장되는가")
    @ValueSource(strings = {"2", "6", "10"})
    @ParameterizedTest
    void saveRaceCountStringToRaceCountInteger(String inputRaceCount) {
        RaceCount raceCount = new RaceCount(inputRaceCount);
        Assertions.assertThat(raceCount.getRaceCount()).isEqualTo(Integer.parseInt(inputRaceCount));
    }
}
