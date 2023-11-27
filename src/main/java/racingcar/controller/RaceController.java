package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.view.OutputView;

public class RaceController {
    private static final int INIT_STATUS_NUMBER = 0;

    private Cars cars;
    private RaceCount raceCount;

    public void start() {
        String a = Console.readLine();
        String b = Console.readLine();
        cars = new Cars(a);
        raceCount = new RaceCount(b);
        runRace(cars.getCars(), raceCount.getRaceCount());
    }

    private void runRace(List<String> cars, int raceCount) {
        OutputView.printCarsStatusMessage();
        runRaceIteration(initCarStatus(cars), raceCount);
    }

    private void runRaceIteration(HashMap<String, Integer> carsStatus, int raceCount) {
        HashMap<String, Integer> newCarsStatus = carsStatus;
        for (int raceIndex = 0; raceIndex < raceCount; raceIndex++) {
            Race race = new Race(newCarsStatus);
            newCarsStatus = race.getCarStatusLogs();
            OutputView.printCarsStatus(newCarsStatus);
        }
        Race race = new Race(newCarsStatus);
    }

    private HashMap<String, Integer> initCarStatus(List<String> cars) {
        return (HashMap<String, Integer>) cars.stream()
                .collect(Collectors.toMap(key -> key, value -> INIT_STATUS_NUMBER));
    }
}
