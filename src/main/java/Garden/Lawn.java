package Garden;
import Restrictions.RestrictionLevel;

import java.util.Calendar;

import static Restrictions.RestrictionLevel.*;

/**
 * Created by Trevor on 2017-02-13.
 */
public class Lawn implements GardenItem {
    private final int RESTRICTED_START_HOUR = 4;
    private final int RESTRICTED_END_HOUR = 9;

    private String name;
    private GardenItemStatus status;

    public Lawn(String name) {
        this.name = name;
        status = GardenItemStatus.HYDRATED;
    }

    @Override
    public GardenItemStatus getStatus() {
        return status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean checkWater(RestrictionLevel restrictionLevel) {
        switch (restrictionLevel) {
            case NO_RESTRICTION:
                return true;
            case STAGE_1:
            case STAGE_2:
                int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
                return hour >= RESTRICTED_START_HOUR && hour < RESTRICTED_END_HOUR;
            case STAGE_3:
            case STAGE_4:
                return false;
        }
        // cannot get here
        return false;
    }
}
