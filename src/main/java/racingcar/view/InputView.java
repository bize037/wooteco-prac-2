package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.constants.Message;

public class InputView {
    public static String inputCarsName() {
        System.out.println(Message.INPUT_CARS_NAME.getMessage());
        return Console.readLine();
    }

    public static String inputRaceCount() {
        System.out.println(Message.INPUT_RACE_COUNT.getMessage());
        return Console.readLine();
    }
}
