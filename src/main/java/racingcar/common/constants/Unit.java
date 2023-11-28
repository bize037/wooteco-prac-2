package racingcar.common.constants;

public enum Unit {
    COMMA(","),
    HYPHEN("-"),
    COLON(":");

    private static final String SPACE = " ";

    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public String getUnitSpace() {
        return unit + SPACE;
    }

    public String getSpaceUnitSpace() {
        return SPACE + unit + SPACE;
    }
}
