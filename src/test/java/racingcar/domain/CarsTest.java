package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {
    @DisplayName("문자열로 들어온 자동차 이름들이 ,를 기준으로 리스트 형태로 저장되는가")
    @ValueSource(strings = {"qwer,asdf,zxcv,tyu", "ter,gdf,v,wwe", "qerdd"})
    @ParameterizedTest
    void saveCarsStringToCarsList(String carsCsv) {
        Cars cars = new Cars(carsCsv);
        assertThat(cars.getCars()).isEqualTo(Arrays.asList(carsCsv.split(",")));
    }
}
