package m.unihackmini;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 9/04/16.
 */
<<<<<<< HEAD
public class Restroom{
    // restroom stats
=======
public class Restroom {
    // restroom details
    private String name;
    private String location;
    private int gender;
    private Boolean hasDisabled;
    // restroom stats based off reviews
>>>>>>> origin/master
    private ArrayList<Review> reviews;
    
    private int bathroomRating;
    private int bathroomCleanliness;
    private int bathroomModernity;
    private int tpAbundance;
    private String dryer;
    private boolean wifi;
    private ArrayList<String> reviewComments;
    //private int bathroomTraffic;

    public Restroom(String name, String location, int gender, Boolean hasDisabled) {
        this.name = name;
        this.location = location;
        this.gender = gender;
        this.hasDisabled = hasDisabled;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

<<<<<<< HEAD
    public void upateStats() {
        //for (int i=0; reviews.size(); i++) {

        //}
=======
    public Boolean getHasDisabled() {
        return hasDisabled;
    }

    public int getGender() {
        return gender;
>>>>>>> origin/master
    }

    // THIS IS A CHANGE
}


