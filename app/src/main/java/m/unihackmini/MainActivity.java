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
        // create a Restroom that in turn creates 2 Reviews and stores it all on Firebase for testing
        System.out.println("tim test");
        Restroom restroom = new Restroom("IT Toilets", "Building 72", 3, true, "Paper Towel");
        Firebase myFirebaseRef = new Firebase("https://unihackmini.firebaseio.com/");
        //myFirebaseRef.child("restroom").setValue(null);
        myFirebaseRef.child("restroom").child("restroom1").setValue(restroom);

    }

}
