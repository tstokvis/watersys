
import Garden.GardenItem;
import Garden.Lawn;
import Garden.Planter;
import Restrictions.WaterRestrictionParsingException;
import Restrictions.WaterRestrictions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Trevor on 2017-02-18.
 */
public class Main {


    private static final String EVERYTHINGS_FINE = "Parsing succeed on last check";

    private static WaterRestrictions waterRestrictions;
    private static List<GardenItem> gardenItems = new ArrayList<>();
    private static String restrictionParsingException = EVERYTHINGS_FINE;

    public static void main(String[] args) throws InterruptedException, WaterRestrictionParsingException {
        waterRestrictions = new WaterRestrictions();
        addGardens();

        ClockLabel dateLable = new ClockLabel("date");
        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dayLable = new ClockLabel("day");

        JFrame frame = new JFrame("Watering System");
        frame.setSize(300, 150);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 3));
        frame.add(dateLable);
        frame.add(timeLable);
        frame.add(dayLable);

        JLabel restrictionLevelTitle = new JLabel("Restriction Level:");
        String waterRestrictionLevel = waterRestrictions.getRestrictionLevel().toString();
        JLabel restrictionLevel = new JLabel(waterRestrictionLevel);
        restrictionLevelTitle.setFont(new Font("sans-serif", Font.PLAIN, 40));
        restrictionLevel.setFont(new Font("sans-serif", Font.PLAIN, 40));
        restrictionLevel.setHorizontalTextPosition(SwingConstants.LEFT);
        frame.add(restrictionLevelTitle);
        frame.add(restrictionLevel);
        frame.add(new JLabel(EVERYTHINGS_FINE));



        for (GardenItem gardenItem : gardenItems) {
            JLabel gardenLabel = new JLabel(gardenItem.getName());
            JLabel gardenStatus = new JLabel(gardenItem.getStatus().toString());
            JLabel error = new JLabel("No errors on last check");
            gardenLabel.setFont(new Font("sans-serif", Font.PLAIN, 40));
            gardenStatus.setFont(new Font("sans-serif", Font.PLAIN, 40));
            frame.add(gardenLabel);
            frame.add(gardenStatus);
            frame.add(error);
        }

        frame.setVisible(true);
    }

    private static void addGardens() {
        gardenItems.add(new Lawn("Backyard Lawn"));
        gardenItems.add(new Lawn("Front Lawn"));
        gardenItems.add(new Planter("Veggie Planter"));
        gardenItems.add(new Planter("Backyard Planter"));
        gardenItems.add(new Planter("Front Planter"));
        gardenItems.add(new Planter("Stairs Planter"));
    }
}

