package Garden;

import Garden.GardenItemStatus;
import Restrictions.RestrictionLevel;

public interface GardenItem {

    boolean checkWater(RestrictionLevel restrictionLevel);

    GardenItemStatus getStatus();

    String getName();

}
