package m.unihackmini;

/**
 * Created by David on 9/04/16.
 */
public class ReviewData {
    String hasWifi;
    String rating;

    public ReviewData(){

    }

    public String getRating() {
        return rating;
    }

    public String getHasWifi() {
        return hasWifi;
    }

    public String description() {
        return "This is a review object. Rating: " + getRating() + " Wifi: " + getHasWifi();
    }
}
