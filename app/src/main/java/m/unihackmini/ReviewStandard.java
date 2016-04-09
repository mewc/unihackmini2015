    package m.unihackmini;

    /**
     * Created by David on 9/04/16.
     */
    public class ReviewStandard {
        private String id;
        private int rating;             // star rating
        private int cleanliness;
        private int modernity;
        private int traffic;
        private int duration;
        private Boolean wifi;
        private String comment;
        private String username;        // can be anon


        public ReviewStandard(String newId, int theRating, int theCleanliness, int theModernity, int theTraffic, int theDuration, Boolean hasWifi, String theComment, String theUsername) {
            id = newId;
            rating = theRating;
            cleanliness = theCleanliness;
            modernity = theModernity;
            traffic = theTraffic;
            duration = theDuration;
            wifi = hasWifi;
            comment = theComment;
            username = theUsername;
        }

        public int getRating() {
            return rating;
        }

        public Boolean getWifi() {
            return wifi;
        }

        public int getCleanliness() {
            return cleanliness;
        }

        public int getDuration() {
            return duration;
        }

        public String getId() {
            return id;
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

        public String description(){
            return comment + "\n" + username + "duration: " + duration + ", Traffic:" + traffic + " Rating: " + rating;
        }

    }



