package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.RaceCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private static final int INIT_STATUS_NUMBER = 0;
    private static final int DEFAULT_RACE_INDEX = 0;
    private static final int DEFAULT_CAR_STATUS = 0;

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
        cars = new Cars(InputView.inputCarsName());
    }

    private void enterRaceCount() {
        raceCount = new RaceCount(InputView.inputRaceCount());
    }

    private void runRace(List<Car> cars, int raceCount) {
        OutputView.printCarsStatusMessage();
        runRaceIteration(initCarsStatus(cars), raceCount);
    }

    private void announceWinner() {
        OutputView.printAnnounceWinner(getAnnounceWinner(race.getCarStatusLogs()));
    }

    private HashMap<Car, Integer> initCarsStatus(List<Car> cars) {
        return (HashMap<Car, Integer>) cars.stream()
                .collect(Collectors.toMap(key -> key, value -> INIT_STATUS_NUMBER));
    }

    private void runRaceIteration(HashMap<Car, Integer> carsStatus, int raceCount) {
        HashMap<Car, Integer> newCarsStatus = carsStatus;
        for (int raceIndex = DEFAULT_RACE_INDEX; raceIndex < raceCount; raceIndex++) {
            race = new Race(newCarsStatus);
            newCarsStatus = race.getCarStatusLogs();
            OutputView.printCarsStatus(newCarsStatus);
        }
        race = new Race(newCarsStatus);
    }

    private List<Car> getAnnounceWinner(HashMap<Car, Integer> carsStatus) {
        return carsStatus.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxStatus(carsStatus))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private int maxStatus(HashMap<Car, Integer> carsStatus) {
        return carsStatus.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(DEFAULT_CAR_STATUS);
    }
}
