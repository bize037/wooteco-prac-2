package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.constants.Message;
import racingcar.common.constants.Unit;
import racingcar.domain.Car;

public class OutputView {
    public static void printCarsStatusMessage() {
        System.out.println(Message.OUTPUT_CARS_STATUS.getMessage());
    }

    public static void printCarsStatus(HashMap<Car, Integer> carsStatus) {
        carsStatus.forEach((car, carStatus) -> {
            System.out.println(car + Unit.COLON.getSpaceUnitSpace() + Unit.HYPHEN.getUnit().repeat(carStatus));
        });
        System.out.println();
    }

    public static void printAnnounceWinner(List<Car> announceWinner) {
        System.out.print(Message.OUTPUT_WINNERS.getMessage() + Unit.COLON.getSpaceUnitSpace());
        System.out.println(announceWinner.stream()
                .map(Object::toString)
                .collect(Collectors.joining(Unit.COMMA.getUnitSpace())));
    }
}
