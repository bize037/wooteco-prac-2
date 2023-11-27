package racingcar.view;

import java.util.HashMap;
import racingcar.common.constants.Unit;

public class OutputView {

    public static void printCarsStatusMessage() {
        System.out.println("실행 결과");
    }
    public static void printCarsStatus(HashMap<String, Integer> carsStatus) {
        carsStatus.forEach((car, carStatus) -> {
            System.out.println(car + Unit.COLON.getSpaceUnitSpace() + Unit.HYPHEN.getUnit().repeat(carStatus));
        });
        System.out.println();
    }
}
