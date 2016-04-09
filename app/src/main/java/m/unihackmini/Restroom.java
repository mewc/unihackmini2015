package m.unihackmini;

import android.os.Parcelable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 9/04/16.
 */
public class Restroom{
    // restroom stats
    private ArrayList<Review> reviews;
    private int bathroomRating;
    private int bathroomCleanliness;
    private int bathroomModernity;
    //private int bathroomTraffic;
    private int abundanceTP;
    private String dryer;
    private boolean wifi;
    private ArrayList<String> reviewComments;

    private String location;
    private String name;
    private int gender;
    private Boolean hasDisabled;

    public Restroom(String location, String name, int gender, Boolean hasDisabled) {
        this.location = location;
        this.gender = gender;
        this.hasDisabled = hasDisabled;
    }


    public void testCreateReview() {
        String newId = UUID.randomUUID().toString();
        int theRating = 1;
        int theCleanliness = 2;
        int theModernity = 1;
        int theTraffic = 1;
        int theDuration = 15;
        boolean hasWifi = true;
        String theComment = "Nice";
        String theUsername = "Anon";

        Review aReview = new Review(newId, theRating, theCleanliness, theModernity, theTraffic, theDuration, hasWifi, theComment, theUsername);

        reviews.add(aReview);

    }

    public void upateStats() {
        //for (int i=0; reviews.size(); i++) {

        //}
    }
}


