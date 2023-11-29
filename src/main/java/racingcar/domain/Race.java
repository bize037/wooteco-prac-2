package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Race {
    private static final int MIN_RANDOM_PICK_NUMBER = 0;
    private static final int MAX_RANDOM_PICK_NUMBER = 9;
    private static final int FORWARD_THRESHOLD_RANDOM_PICK_NUMBER = 4;
    private static final int FORWARD_DISTANCE = 1;
    private static final int NOT_FORWARD_DISTANCE = 0;

    private HashMap<Car, Integer> carStatusLogs = new HashMap<>();

    public Race(HashMap<Car, Integer> carsStatus) {
        this.carStatusLogs = driveForward(carsStatus);
    }

    public HashMap<Car, Integer> getCarStatusLogs() {
        return carStatusLogs;
    }

    private HashMap<Car, Integer> driveForward(HashMap<Car, Integer> carStatus) {
        carStatus.forEach((car, forwardStatus) -> {
            carStatus.put(car, forwardStatus + decideForwardOrNot());
        });
        return carStatus;
    }

    private int decideForwardOrNot() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_PICK_NUMBER, MAX_RANDOM_PICK_NUMBER) >= FORWARD_THRESHOLD_RANDOM_PICK_NUMBER) {
            return FORWARD_DISTANCE;
        }
        return NOT_FORWARD_DISTANCE;
    }
}
