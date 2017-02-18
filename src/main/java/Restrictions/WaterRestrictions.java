package Restrictions;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Trevor on 2017-02-13.
 */
public class WaterRestrictions {

    private static final String VANCOUVER_WATER_RESTRICTION_URL = "http://vancouver.ca/home-property-development/understanding-watering-restrictions.aspx";
    private static final String WATER_RESTRICTION_STRING_OBJECT = "h2";
    private static final String NO_WATER_RESTRICTIONS = "no water restrictions";
    private static final String STAGE_1 = "stage 1";
    private static final String STAGE_2 = "stage 2";
    private static final String STAGE_3 = "stage 3";
    private static final String STAGE_4 = "stage 4";

    private RestrictionLevel overrideRestrictionLevel;

    public RestrictionLevel getRestrictionLevel() throws WaterRestrictionParsingException {
        if (overrideRestrictionLevel != null) {
            return overrideRestrictionLevel;
        } else {
            return getCurrentRestrictionLevel();
        }
    }

    public void setOverrideRestrictionLevel(RestrictionLevel restrictionLevel) {
        overrideRestrictionLevel = restrictionLevel;
    }

    private RestrictionLevel getCurrentRestrictionLevel() throws WaterRestrictionParsingException {
        Document doc = getDocumentFromURL();
        String restrictionString = getRestrictionString(doc);

        if (restrictionString.contains(NO_WATER_RESTRICTIONS)) {
            return RestrictionLevel.NO_RESTRICTION;
        } else if (restrictionString.contains(STAGE_1)) {
            return RestrictionLevel.STAGE_1;
        } else if (restrictionString.contains(STAGE_2)) {
            return RestrictionLevel.STAGE_2;
        } else if (restrictionString.contains(STAGE_3)) {
            return RestrictionLevel.STAGE_3;
        } else if (restrictionString.contains(STAGE_4)) {
            return RestrictionLevel.STAGE_4;
        } else {
            throw new WaterRestrictionParsingException("Correct result not found!");
        }
    }

    private Document getDocumentFromURL() throws WaterRestrictionParsingException {
        try {
            return Jsoup.connect(VANCOUVER_WATER_RESTRICTION_URL).get();
        } catch (Exception e) {
            throw new WaterRestrictionParsingException("Error parsing website: " + e.toString());
        }
    }

    private String getRestrictionString(Document doc) throws WaterRestrictionParsingException {
        try {
            Elements elements = doc.select(WATER_RESTRICTION_STRING_OBJECT);
            return elements.get(1).toString();
        } catch (Exception e) {
            throw new WaterRestrictionParsingException("Water restrictions heading is not where it should be");
        }
    }
}