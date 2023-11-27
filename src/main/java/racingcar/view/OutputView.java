package racingcar.view;

import java.util.HashMap;

public class OutputView {
    public static void printCarStatus(HashMap<String, Integer> carsStatus) {
        System.out.println("실행 결과");
        carsStatus.forEach((car, carStatus) -> {
            System.out.println(car + " : " + "-".repeat(carStatus));
        });

    }
}
