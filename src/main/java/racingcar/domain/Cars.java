package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<String> cars = new ArrayList<>();

    public Cars(String carsCsv) {
        this.cars = Arrays.asList(carsCsv.split(","));
    }

    public List<String> getCars() {
        return cars;
    }
}
