package m.unihackmini;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 9/04/16.
 */
public class Restroom {
    public static int restroomId;

    // restroom details
    private int id;
    private String name;
    private String location;
    private int gender;
    private Boolean hasDisabled;
    // restroom stats based off reviews

    private int restroomRating;
    private int restroomCleanliness;
    private int restroomModernity;
    private int tpAbundance;
    private String dryer;
    private boolean wifi;
    private ArrayList<String> reviewComments;

    //private int restroomTraffic;

    public Restroom(String name, String location, int gender, Boolean hasDisabled) {

        this.name = name;
        this.location = location;
        this.gender = gender;
        this.hasDisabled = hasDisabled;
        this.id = restroomId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getHasDisabled() {
        return hasDisabled;
    }

    public int getGender() {
        return gender;
    }

 
}


