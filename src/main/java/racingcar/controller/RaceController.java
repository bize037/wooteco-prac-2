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

    private void runRaceIteration(HashMap<String, Integer> carStatus, int raceCount) {
        for (int raceIndex = 0; raceIndex < raceCount; raceIndex++) {
            race = new Race(carStatus);
            OutputView.printCarStatus(race.getCarStatusLogs());
        }
    }

    private HashMap<String, Integer> initCarStatus(List<String> cars) {
        return (HashMap<String, Integer>) cars.stream()
                .collect(Collectors.toMap(key -> key, value -> 0));
    }
}
