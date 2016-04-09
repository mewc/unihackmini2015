package m.unihackmini;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by David on 9/04/16.
 */
public class Restroom implements Parcelable {
    // restroom details
    private String name;
    private String location;
    private int gender;
    private boolean hasDisabled;
    private String dryer;

    // restroom stats based off reviews
    private ArrayList<Review> reviews = new ArrayList<>();

    // from reviews: no need for private variables, they can be gotten from reviews
    /*
    private double averageRating;
    private double averageCleanliness;
    private double averageModernity;
    private double averageTP;
    private boolean wifi;
    private ArrayList<String> reviewComments;
    private int averageBathroomTraffic;
    private int averageOdor;
    */

    public void setName(String name) {
        this.name = name;
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public Restroom(String name, String location, int gender, boolean hasDisabled, String dryer) {
        this.name = name;
        this.location = location;

        this.gender = gender;
        this.hasDisabled = hasDisabled;
        this.dryer = dryer;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getGender(){
        return gender;
    }

    public Boolean getHasDisabled() {
        return hasDisabled;
    }


    public String getDryer() {
        return dryer;
    }

    //////////////FROM REVIEWS/////////////////////

    public double getAverageRating() {
        double average = 0;
        for(Review rev : reviews){
            average += rev.getRating();
        }
        return average / reviews.size();
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public double getAverageCleanliness() {
        double average = 0;
        for(Review rev : reviews){
            average += rev.getCleanliness();
        }
        return average / reviews.size();
    }

    public double getAverageModernity() {
        double average = 0;
        for(Review rev : reviews){
            average += rev.getModernity();
        }
        return average / reviews.size();
    }

    public double getAverageTP() {
        double average = 0;
        for(Review rev : reviews){
            average += rev.getTpAbundance();
        }
        return average / reviews.size();
    }

    public double getAverageOdor() {
        double average = 0;
        for(Review rev : reviews){
            average += rev.getOdor();
        }
        return average / reviews.size();
    }

    public double getAverageTraffic() {
        double average = 0;
        for(Review rev : reviews){
            average += rev.getTraffic();
        }
        return average / reviews.size();
    }

    public boolean isWifi() {
        double average = 0;
        for(Review rev : reviews){
            average += (rev.isHasWifi() ? 1 : -1);
        }
        return (average > 0); // returns true if most users say it has wifi
    }

    public ArrayList<String> getReviewComments() {
        ArrayList<String> comments = new ArrayList<>();
        for(Review rev : reviews){
            comments.add(rev.getComment());
        }
        return comments;
    }


    //////////////////////////PARCEL CRAP////////////////////////////////////////

    // constructor initializes values based on implemented Parcelable interface
    public Restroom(Parcel in) {
        name = in.readString();
        location = in.readString();
        gender = in.readInt();
        hasDisabled = in.readByte() != 0;
        reviews = in.readArrayList(Review.class.getClassLoader());
        dryer = in.readString();
        /*
        averageRating = in.readDouble();
        averageCleanliness = in.readDouble();
        averageModernity = in.readDouble();
        averageTP = in.readDouble();
        wifi = in.readByte() != 0;
        reviewComments = in.readArrayList(String.class.getClassLoader());
        */
    }

    // generates a Parcelable instance of this class from a Parcel
    public static final Creator<Restroom> CREATOR = new Creator<Restroom>() {
        @Override
        public Restroom createFromParcel(Parcel in) {
            return new Restroom(in);
        }

        @Override
        public Restroom[] newArray(int size) {
            return new Restroom[size];
        }
    };

    // used to describe special objects, not modified bery often
    @Override
    public int describeContents() {
        return 0;
    }

    // outputs the format the parcel writes values
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(location);
        parcel.writeInt(gender);
        parcel.writeByte((byte) (hasDisabled ? 1 : 0));
        parcel.writeList(reviews);
        parcel.writeString(dryer);
        /*
        parcel.writeDouble(averageRating);
        parcel.writeDouble(averageCleanliness);
        parcel.writeDouble(averageModernity);
        parcel.writeDouble(averageTP);
        parcel.writeByte((byte) (wifi ? 1 : 0));
        parcel.writeList(reviewComments);
        */
    }
}


