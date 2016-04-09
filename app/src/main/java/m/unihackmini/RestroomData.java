package m.unihackmini;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by David on 9/04/16.
 */
public class RestroomData {

    private String name;
    private int gender;
    //private ArrayList<Review> reviews;

    private String location;

    private int id;
    private int hasDisabled;

    public RestroomData(){
     //   reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public int getGender() {
        return gender;
    }

    //public ArrayList<Review> getReviews() {
    //    return reviews;
    //}


    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public int hasDisabled() {
        return hasDisabled;
    }


}
