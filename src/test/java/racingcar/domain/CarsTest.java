package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.constants.Unit;

public class CarsTest {
    @DisplayName("문자열로 들어온 자동차 이름들이 ,를 기준으로 리스트 형태로 저장되는가")
    @ValueSource(strings = {"qwer,asdf,zxcv,tyu", "ter,gdf,v,wwe", "qerdd"})
    @ParameterizedTest
    void saveCarsStringToCarsList(String inputCarsCsv) {
        Cars cars = new Cars(inputCarsCsv);
        assertThat(cars.getCars()).isEqualTo(Arrays.stream(inputCarsCsv.split(Unit.COMMA.getUnit()))
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    @DisplayName("공백이 입력된 경우 예외 처리 되는가")
    @ValueSource(strings = {"", " "})
    @ParameterizedTest
    void validateCarsCsvNotBlank(String inputCarsCsv) {
        assertThatThrownBy(() -> new Cars(inputCarsCsv))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정된 길이를 넘어선 문자열이 입력된 경우 예외 처리 되는가")
    @ValueSource(strings = {"qwerasdf,asdf,qwer", "qwer,asdfgh,zxc", "qwerzxcv"})
    @ParameterizedTest
    void validateCarsCsvLengthNotExceeding(String inputCarsCsv) {
        assertThatThrownBy(() -> new Cars(inputCarsCsv))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름 중 중복된 이름이 입력된 경우 예외 처리 되는가")
    @ValueSource(strings = {"asdf,asdf,qwer", "qwer,zxc,asdf,zxc", "qwerzxcv,qwerzxcv"})
    @ParameterizedTest
    void validateCarsCsvNotDuplicates(String inputCarsCsv) {
        assertThatThrownBy(() -> new Cars(inputCarsCsv))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
