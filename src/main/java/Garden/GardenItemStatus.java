package Garden;

/**
 * Created by Trevor on 2017-02-13.
 */
public enum GardenItemStatus {
    HYDRATED("Hydrated"),
    WATERING("Watering In Progress"),
    NEEDS_WATER("Needs Water");

    private final String text;

    GardenItemStatus(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
