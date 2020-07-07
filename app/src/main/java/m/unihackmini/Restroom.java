package m.unihackmini;

import java.util.ArrayList;

/**
 * Created by David on 9/04/16.
 * Modified 10/4/16
 */
public class Restroom {


    public static int restroomId;

    // restroom details
    private int id;
    private String name;
    private String location;
    private int gender;
    private int hasDisabled;
    // restroom stats based off reviews

    private int restroomRating;
    private int restroomCleanliness;
    private int restroomModernity;
    private int tpAbundance;
    private String dryer;
    private boolean wifi;
    private ArrayList<String> reviewComments;
    private ArrayList<Review> reviews;

    //private int restroomTraffic;

    public Restroom(String name, String location, int gender, int hasDisabled) {

        this.name = name;
        this.location = location;
        this.gender = gender;
        this.hasDisabled = hasDisabled;
        this.id = restroomId;
        restroomId += 1;
        this.reviews = new ArrayList<>();
        Review aReview = new Review("1",2,3,3,true,"comment", "anon", 2);
        Review bReview = new Review("3",2,3,3,false,"comment2", "josh", 2);
        this.reviews.add(aReview);
        this.reviews.add(bReview);

    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getHasDisabled() {
        return hasDisabled;
    }

    public int getGender() {
        return gender;
    }

    public ArrayList<Review> getReviews() { return reviews;}
    public int getId() {return id;}

    // note: getters translated into fields in Firebase
 
}


