package m.unihackmini;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by David on 9/04/16.
 */
public class Review implements Parcelable{
    public static int reviewID=0;

    // quick review fields (8 items)
    private int id;
    private String restroomID;
    private int rating;             // 1-10 rating
    private int cleanliness;
    private boolean hasWifi;
    private int duration;
    private String comment;
    private String username;        // can be anon
    private int odor;

    // standard review  (10 items)
    private int modernity;
    private int traffic;
    //private boolean hasDisabled;

    // long review fields (12 items)
    private int tpAbundance;
    //private String dryer;

    // quick review constructor
    public Review(String id, int rating, int cleanliness, int duration, boolean hasWifi, String comment, String username, int odor) {
        this.restroomID = id;
        this.rating = rating;
        this.cleanliness = cleanliness;
        this.duration = duration;
        this.hasWifi = hasWifi;
        this.comment = comment;
        this.username = username;
        this.odor = odor;
    }

    // standard review constructor
    public Review(String id, int rating, int cleanliness, int modernity, int traffic, int duration, boolean hasWifi, String comment, String username, int odor, boolean hasDisabled) {
        this.restroomID = id;
        this.rating = rating;
        this.cleanliness = cleanliness;
        this.modernity = modernity;
        this.traffic = traffic;
        this.duration = duration;
        this.hasWifi = hasWifi;
        this.comment = comment;
        this.username = username;
        this.odor = odor;
        //this.hasDisabled = hasDisabled;
    }

    // long review constructor
    public Review(String id, int rating, int cleanliness, int modernity, int traffic, int duration, boolean hasWifi, String comment, String username, int tpAbundance, int odor) {
        this.restroomID = id;
        this.rating = rating;
        this.id = reviewID;
        reviewID++;
        this.cleanliness = cleanliness;
        this.modernity = modernity;
        this.traffic = traffic;
        this.duration = duration;
        this.hasWifi = hasWifi;
        this.comment = comment;
        this.username = username;
        this.tpAbundance = tpAbundance;
        this.odor = odor;
    }

    public int getRating() {
        return rating;
    }

    public Boolean getWifi() {
        return hasWifi;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public int getDuration() {
        return duration;
    }

    public String getId() {
        return restroomID;
    }

    public int getModernity() {
        return modernity;
    }

    public int getTraffic() {
        return traffic;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public String getRestroomID() {
        return restroomID;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public int getOdor() {
        return odor;
    }

    public int getTpAbundance() {
        return tpAbundance;
    }

    public String description() {
        return comment + "\n" + username + "duration: " + duration + ", Traffic:" + traffic + " Rating: " + rating;
    }

    ////////////////////PARCEL CRAP//////////////////////////

    // constructor initializes values based on implemented Parcelable interface
    public Review(Parcel in) {
        restroomID = in.readString();
        rating = in.readInt();
        cleanliness = in.readInt();
        hasWifi = in.readByte() != 0;
        duration = in.readInt();
        comment = in.readString();
        username = in.readString();
        odor = in.readInt();
        modernity = in.readInt();
        traffic = in.readInt();
        tpAbundance = in.readInt();
    }

    // generates a Parcelable instance of this class from a Parcel
    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
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
        parcel.writeString(restroomID);
        parcel.writeInt(rating);
        parcel.writeInt(cleanliness);
        parcel.writeByte((byte) (hasWifi ? 1 : 0));
        parcel.writeInt(duration);
        parcel.writeString(comment);
        parcel.writeString(username);
        parcel.writeInt(odor);
        parcel.writeInt(modernity);
        parcel.writeInt(traffic);
        parcel.writeInt(tpAbundance);
    }

    public int getReviewID(){
        return this.id;
    }
}



