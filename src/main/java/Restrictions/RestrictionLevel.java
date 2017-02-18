package Restrictions;

/**
 * Created by Trevor on 2017-02-13.
 */
public enum RestrictionLevel {
    NO_RESTRICTION("No Restrictions"),
    STAGE_1("Stage 1"),
    STAGE_2("Stage 2"),
    STAGE_3("Stage 3"),
    STAGE_4("Stage 4");

    private final String text;

    RestrictionLevel(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
