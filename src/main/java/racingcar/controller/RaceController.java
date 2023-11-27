package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Race;

public class RaceController {
    private Race race;

    public void start() {

    }

    private void racing(List<String> cars, int raceCount) {
        race = new Race(initCarStatus(cars), raceCount);
    }

    private HashMap<String, Integer> initCarStatus(List<String> cars) {
        return (HashMap<String, Integer>) cars.stream()
                .collect(Collectors.toMap(key -> key, value -> 0));
    }
}
