package racingcar.common.constants;

public enum Unit {
    COMMA(",");

    private static final String SPACE = " ";

    private String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public String getUnitSpace() {
        return unit + SPACE;
    }
}
