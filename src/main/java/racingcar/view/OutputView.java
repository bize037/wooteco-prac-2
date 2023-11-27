package racingcar.view;

import java.util.HashMap;

public class OutputView {

    public static void printCarsStatusMessage() {
        System.out.println("실행 결과");
    }
    public static void printCarsStatus(HashMap<String, Integer> carsStatus) {
        carsStatus.forEach((car, carStatus) -> {
            System.out.println(car + " : " + "-".repeat(carStatus));
        });
        System.out.println();
    }
}
