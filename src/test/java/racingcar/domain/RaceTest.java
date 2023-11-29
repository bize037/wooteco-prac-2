package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RaceTest {
    private static final int FORWARD_DISTANCE = 1;

    @DisplayName("자동차의 상태가 그대로거나 FORWARD_DISTANCE만큼 전진한 상태로 저장되는가")
    @MethodSource("carsStatus")
    @ParameterizedTest
    void saveRaceCountStringToRaceCountInteger(HashMap<Car, Integer> inputCarsStatus) {
        HashMap<Car, Integer> carsStatus = new HashMap<>(inputCarsStatus);
        Race race = new Race(inputCarsStatus);

        race.getCarStatusLogs().forEach((car, status) -> {
            assertThat(status).isIn(carsStatus.get(car), carsStatus.get(car) + FORWARD_DISTANCE);
        });
    }

    private static Stream<HashMap<Car, Integer>> carsStatus() {
        HashMap<Car, Integer> carsStatusCase1 = new HashMap<>();
        carsStatusCase1.put(new Car("qwer"), 4);
        carsStatusCase1.put(new Car("asdf"), 2);
        carsStatusCase1.put(new Car("zxcv"), 2);

        HashMap<Car, Integer> carsStatusCase2 = new HashMap<>();
        carsStatusCase2.put(new Car("heart"), 1);
        carsStatusCase2.put(new Car("diamond"), 5);
        carsStatusCase2.put(new Car("space"), 2);
        carsStatusCase2.put(new Car("clover"), 2);

        HashMap<Car, Integer> carsStatusCase3 = new HashMap<>();
        carsStatusCase3.put(new Car("woo"), 1);
        carsStatusCase3.put(new Car("teco"), 2);

        return Stream.of(carsStatusCase1, carsStatusCase2, carsStatusCase3);
    }
}
