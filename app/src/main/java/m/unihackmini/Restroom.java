package m.unihackmini;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 9/04/16.
 */
public class Restroom {
    private ArrayList<ReviewAdvanced> reviewsAdvanced;
    private ArrayList<ReviewStandard> reviewsStandard;
    private int bathroomRating;
    private int bathroomCleanliness;
    private int bathroomModernity;
    //private int bathroomTraffic;
    private boolean wifi;
    private ArrayList<String> reviewComments;

    private String location;
    private String getTo;
    private int gender;
    private Boolean disabled;

    public Restroom(String theLocation, String howGetTo, int theGender, Boolean hasDisabled) {
        reviewsAdvanced = new ArrayList<>();
        reviewsStandard = new ArrayList<>();
        location = theLocation;
        getTo = howGetTo;
        gender = theGender;
        disabled = hasDisabled;
    }

    public void createReviewAdvanced() {
        String newId = UUID.randomUUID().toString();
        int theRating = 1;
        int theCleanliness = 2;
        int theModernity = 1;
        int theTraffic = 1;
        int theDuration = 15;
        boolean hasWifi = true;
        String theComment = "Nice";
        String theUsername = "Anon";
        int tpLvl = 5;
        String theDryer = "New wind blowing machine";

        ReviewAdvanced aReview = new ReviewAdvanced(tpLvl, theDryer, newId, theRating, theCleanliness, theModernity, theTraffic, theDuration, hasWifi, theComment, theUsername);

        reviewsAdvanced.add(aReview);

    }

    public void createReviewStandard() {
        String newId = UUID.randomUUID().toString();
        int theRating = 1;
        int theCleanliness = 2;
        int theModernity = 1;
        int theTraffic = 1;
        int theDuration = 15;
        boolean hasWifi = true;
        String theComment = "Nice";
        String theUsername = "Anon";

        ReviewStandard aReview = new ReviewStandard(newId, theRating, theCleanliness, theModernity, theTraffic, theDuration, hasWifi, theComment, theUsername);

        reviewsStandard.add(aReview);

    }

    public void upateStats() {
        for (int i=0; reviewsStandard.size(); i++) {

        }
    }
}


