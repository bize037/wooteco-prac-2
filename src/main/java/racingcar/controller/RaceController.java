package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.view.OutputView;

public class RaceController {
    private static final int INIT_STATUS_NUMBER = 0;

    private Cars cars;
    private RaceCount raceCount;
    private Race race;

    public void start() {
        enterCars();
        enterRaceCount();
        runRace(cars.getCars(), raceCount.getRaceCount());
        announceWinner();
    }

    private void enterCars() {
        cars = new Cars(Console.readLine());
    }

    private void enterRaceCount() {
        raceCount = new RaceCount(Console.readLine());
    }

    private void runRace(List<String> cars, int raceCount) {
        OutputView.printCarsStatusMessage();
        runRaceIteration(initCarsStatus(cars), raceCount);
    }

    private void runRaceIteration(HashMap<String, Integer> carsStatus, int raceCount) {
        HashMap<String, Integer> newCarsStatus = carsStatus;
        for (int raceIndex = 0; raceIndex < raceCount; raceIndex++) {
            race = new Race(newCarsStatus);
            newCarsStatus = race.getCarStatusLogs();
            OutputView.printCarsStatus(newCarsStatus);
        }
        race = new Race(newCarsStatus);
    }

    private void announceWinner() {
        OutputView.printAnnounceWinner(getAnnounceWinner(race.getCarStatusLogs()));
    }

    private HashMap<String, Integer> initCarsStatus(List<String> cars) {
        return (HashMap<String, Integer>) cars.stream()
                .collect(Collectors.toMap(key -> key, value -> INIT_STATUS_NUMBER));
    }

    private List<String> getAnnounceWinner(HashMap<String, Integer> carsStatus) {
        return carsStatus.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxStatus(carsStatus))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int maxStatus(HashMap<String, Integer> carsStatus) {
        return carsStatus.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}
