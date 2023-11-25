package racingcar.domain;

import racingcar.common.validate.Validate;

public class RaceCount {
    private final int raceCount;

    public RaceCount(String raceCountText) {
        validateRaceCountText(raceCountText);
        raceCount = Integer.parseInt(raceCountText);
    }

    public int getRaceCount() {
        return raceCount;
    }

    private void validateRaceCountText(String raceCountText) {
        Validate.checkStringNotBlank(raceCountText);
        Validate.checkStringNotCharacter(raceCountText);
        Validate.checkStringPositiveInteger(raceCountText);
    }
}
