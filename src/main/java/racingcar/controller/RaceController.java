package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Race;
import racingcar.view.OutputView;

public class RaceController {
    private Race race;

    public void start() {
        // inputData
        // runRace();
    }

    private void runRace(List<String> cars, int raceCount) {
        HashMap<String, Integer> carStatus = initCarStatus(cars);
        runRaceIteration(carStatus, raceCount);
    }

    private void runRaceIteration(HashMap<String, Integer> carsStatus, int raceCount) {
        HashMap<String, Integer> newCarsStatus = carsStatus;
        for (int raceIndex = 0; raceIndex < raceCount; raceIndex++) {
            race = new Race(newCarsStatus);
            newCarsStatus = race.getCarStatusLogs();
            OutputView.printCarStatus(newCarsStatus);
        }
    }

    private HashMap<String, Integer> initCarStatus(List<String> cars) {
        return (HashMap<String, Integer>) cars.stream()
                .collect(Collectors.toMap(key -> key, value -> 0));
    }
}
