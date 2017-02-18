package Garden;

import Restrictions.RestrictionLevel;

public class Planter implements GardenItem {

    private String name;
    private GardenItemStatus status;

    public Planter(String name) {
        this.name = name;
        this.status = GardenItemStatus.HYDRATED;
    }

    @Override
    public boolean checkWater(RestrictionLevel restrictionLevel) {
        return true;
    }

    @Override
    public GardenItemStatus getStatus() {
        return status;
    }

    @Override
    public String getName() {
        return name;
    }
}
