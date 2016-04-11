package m.unihackmini;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.firebase.client.Firebase;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import android.view.WindowManager;

public class MainActivity extends Activity {

    public static ArrayList<Restroom> restroomListGlobal = new ArrayList<>();

    public ArrayList<Restroom> getR(){
        return restroomListGlobal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("");
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Firebase set up
        Firebase.setAndroidContext(this);
        setUpDataListeners();                   // data listeners to respond to changes in restroom
    }

    // called when BROWSE button is pressed
    public void viewRestroomList(View v){
        Intent i = new Intent(this, ViewRestroomListActivity.class);
        startActivity(i);
    }

    public void viewAddRestroom(View v){

        Intent i = new Intent(this, AddRestroomActivity.class);
        startActivity(i);
    }

    // called when MAP button is pressed
    public void viewMap(View v){
        Intent i = new Intent(this, ViewMapActivity.class);
        startActivity(i);
    }

    // don't need this for now
    public void populateFirebaseTest() {
        System.out.println("FIREBASE TEST");
        Firebase myFirebaseRef = new Firebase("https://unihackmini.firebaseio.com/");
        // should start with this i reckon
        myFirebaseRef.child("review").setValue(null);
        myFirebaseRef.child("restroom").setValue(null);

        Map<String, Object> data1 = new HashMap<>();
        Map<String, Object> data2 = new HashMap<>();
        Map<String, Object> data3 = new HashMap<>();
        Map<String, Object> data4 = new HashMap<>();
        // add restroom to Firebase
        data4.put("id", "2");
        data4.put("avgRating", "4");
        data4.put("hasWifi", "False");
        myFirebaseRef.child("restroom").child("restroom1").updateChildren(data4);
        // add reviews to Firebase
        data1.put("restroomID", "2");
        data1.put("rating", "1");
        data1.put("hasWifi", "True");
        myFirebaseRef.child("review").child("review1").updateChildren(data1);
        //data.clear();
        data2.put("restroomID", "2");
        data2.put("rating", "1");
        data2.put("hasWifi", "False");
        myFirebaseRef.child("review").child("review2").updateChildren(data2);
        //data.clear();
        data3.put("restroomID", "1");
        data3.put("rating", "3");
        data3.put("hasWifi", "False");
        myFirebaseRef.child("review").child("review3").updateChildren(data3);
        //data.clear();
    }


    public void setUpDataListeners() {
        Firebase rootRef = new Firebase("https://unihackmini.firebaseio.com/");
        Firebase restroomRef = rootRef.child("restroom");

        restroomRef.addValueEventListener(new ValueEventListener() {        // listen for Restroom
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //Map<String, Object> map = dataSnapshot.getValue(Map.class);
                //Set<String> s = map.keySet();
                //LinkedHashMap<String, Object> restroomLinkedHash = (LinkedHashMap<String, Object>) map.get(s.toArray()[0]);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    public void test() {
        Restroom r1 = createRestroom("R1", "Here", 3, true, "Fast");
        Restroom r2 = createRestroom("R2", "There", 1, false, "Slow");
        Restroom r3 = createRestroom("R3", "Under", 2, true, "Hot");
        Restroom r4 = createRestroom("R4", "Over", 3, false, "Cold");

        Review rev1 = createReview("First", 3, 5, 3, 6, 15, true, "It was pretty nice", "pooper2", 2, 1);
        Review rev2 = createReview("Second", 5, 3, 6, 5, 30, true, "It was nice", "trooper2", 5, 4);
        Review rev3 = createReview("Third", 6, 5, 6, 5, 2, false, "It was crap", "poop", 4, 2);
        Review rev4 = createReview("Fourth", 3, 5, 3, 6, 15, false, "It sucked", "yayayayaya", 5, 10);
        Review rev5 = createReview("Fifth", 10, 10, 10, 10, 60, true, "I just love pooping", "fecesphile", 10, 10);
        Review rev6 = createReview("Sixth", 1, 1, 1, 1, 1, false, "I enjoy nothing in life", "girl", 1, 1);

    }



    public Restroom createRestroom(String name, String location, int gender, boolean hasDisabled, String dryer) {
        Restroom myRestroom = new Restroom(name, location, gender, hasDisabled, dryer);
        Firebase myFirebaseRef = new Firebase("https://unihackmini.firebaseio.com/");
        String restroomEntry = "restroom" + myRestroom.getId();
        myFirebaseRef.child("restroom").child(restroomEntry).setValue(myRestroom);
        return myRestroom;
    }


    public Review createReview(String restroomID, int rating, int cleanliness, int modernity, int traffic, int duration, boolean hasWifi, String comment, String username, int tpAbundance, int odor) {
        Firebase myFirebaseRef = new Firebase("https://unihackmini.firebaseio.com/");
        Review myReview = new Review(restroomID, rating, cleanliness, modernity, traffic, duration, hasWifi, comment, username, tpAbundance, odor);
        String reviewEntry = "review" + myReview.getReviewID();
        myFirebaseRef.child("review").child(reviewEntry).setValue(myReview);
        return myReview;
    }

}
