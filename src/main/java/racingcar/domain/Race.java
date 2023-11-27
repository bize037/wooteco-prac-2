package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Race {
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
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        }
        return 0;
    }
}
