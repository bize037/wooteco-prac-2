package racingcar.domain;

public record Car(String name) {
    @Override
    public String toString() {
        return name;
    }
}
