package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.common.constants.Unit;
import racingcar.common.validate.Validate;

public class Cars {
    private static final int carMaxLength = 5;
    private List<String> cars = new ArrayList<>();

    public Cars(String carsCsv) {
        validateCarsCsv(carsCsv);
        this.cars = Arrays.asList(carsCsv.split(Unit.COMMA.getUnit()));
    }

    public List<String> getCars() {
        return cars;
    }

    private void validateCarsCsv(String carsCsv) {
        Validate.checkStringBlank(carsCsv);
        Validate.checkStringCsvLengthNotExceeding(carsCsv, carMaxLength);
        Validate.checkListDuplicates(Arrays.asList(carsCsv.split(Unit.COMMA.getUnit())));
    }
}
