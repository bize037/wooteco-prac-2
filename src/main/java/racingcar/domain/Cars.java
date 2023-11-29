package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.constants.Unit;
import racingcar.common.validate.Validate;

public class Cars {
    private static final int carMaxLength = 5;

    private List<Car> cars = new ArrayList<>();

    public Cars(String carsCsv) {
        validateCarsCsv(carsCsv);
        this.cars = Arrays.stream(carsCsv.split(Unit.COMMA.getUnit()))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateCarsCsv(String carsCsv) {
        Validate.checkStringNotBlank(carsCsv);
        Validate.checkStringCsvLengthNotExceeding(carsCsv, carMaxLength);
        Validate.checkListNotDuplicates(Arrays.asList(carsCsv.split(Unit.COMMA.getUnit())));
    }
}
