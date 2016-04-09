package m.unihackmini;

/**
 * Created by David on 9/04/16.
 */
public class ReviewAdvanced extends ReviewStandard {
    private int abundanceTP;
    private String dryer;

    public ReviewAdvanced(int levelTP, String theDryer, String newId, int theRating, int theCleanliness, int theModernity, int theTraffic, int theDuration, Boolean hasWifi, String theComment, String theUsername) {
        super(newId, theRating, theCleanliness, theModernity, theTraffic, theDuration, hasWifi, theComment, theUsername);
        abundanceTP = levelTP;
        dryer = theDryer;
    }



}
