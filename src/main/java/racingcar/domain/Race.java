package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Race {
    private HashMap<String, Integer> carStatusLogs = new HashMap<>();

    public Race(HashMap<String, Integer> carsStatus, int raceCount) {
        this.carStatusLogs = racing(carsStatus, raceCount);
    }

    public HashMap<String, Integer> getCarStatusLogs() {
        return carStatusLogs;
    }


    private HashMap<String, Integer> racing(HashMap<String, Integer> carStatus, int raceCount) {
        HashMap<String, Integer> newCarStatus = new HashMap<>();
        for (int raceIndex = 0; raceIndex < raceCount; raceIndex++) {
            newCarStatus = driveForward(carStatus);
        }
        return newCarStatus;
    }

    private HashMap<String, Integer> driveForward(HashMap<String, Integer> carStatus) {
        carStatus.forEach((car, forwardStatus) -> {
            carStatus.put(car, forwardStatus + decideForward());
        });
        return carStatus;
    }

    private int decideForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        }
        return 0;
    }
}
