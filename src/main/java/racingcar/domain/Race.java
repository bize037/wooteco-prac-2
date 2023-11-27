package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Race {
    private static final int MIN_RANDOM_PICK_NUMBER = 0;
    private static final int MAX_RANDOM_PICK_NUMBER = 9;
    private static final int FORWARD_THRESHOLD_RANDOM_PICK_NUMBER = 4;
    private static final int FORWARD_DISTANCE = 1;
    private static final int NOT_FORWARD_DISTANCE = 0;

    private HashMap<String, Integer> carStatusLogs = new HashMap<>();

    public Race(HashMap<String, Integer> carsStatus) {
        this.carStatusLogs = driveForward(carsStatus);
    }

    public HashMap<String, Integer> getCarStatusLogs() {
        return carStatusLogs;
    }

    private HashMap<String, Integer> driveForward(HashMap<String, Integer> carStatus) {
        carStatus.forEach((car, forwardStatus) -> {
            carStatus.put(car, forwardStatus + decideDriveForward());
        });
        return carStatus;
    }

    private int decideDriveForward() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_PICK_NUMBER, MAX_RANDOM_PICK_NUMBER) >= FORWARD_THRESHOLD_RANDOM_PICK_NUMBER) {
            return FORWARD_DISTANCE;
        }
        return NOT_FORWARD_DISTANCE;
    }
}
