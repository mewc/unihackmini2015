package m.unihackmini;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewRestroomListActivity extends AppCompatActivity {
    // Unique identifier for receiving activity result
    public static final int ADD_RESTROOM_REQUEST = 1;
    public static final int ADD_REVIEW_REQUEST = 2;

    private ListView restroomList;
    private RestroomAdaptor adaptor;
    private ArrayList<Restroom> restrooms;

    // for testing
    Restroom r1 = new Restroom("R1", "Here", 3, true, "Fast");
    Restroom r2 = new Restroom("R2", "There", 1, false, "Slow");
    Restroom r3 = new Restroom("R3", "Under", 2, true, "Hot");
    Restroom r4 = new Restroom("R4", "Over", 3, false, "Cold");

    Review rev1 = new Review("First", 3, 5, 3, 6, 15, true, "It was pretty nice", "pooper2", 2, 1);
    Review rev2 = new Review("Second", 5, 3, 6, 5, 30, true, "It was nice", "trooper2", 5, 4);
    Review rev3 = new Review("Third", 6, 5, 6, 5, 2, false, "It was crap", "poop", 4, 2);
    Review rev4 = new Review("Fourth", 3, 5, 3, 6, 15, false, "It sucked", "yayayayaya", 5, 10);
    Review rev5 = new Review("Fifth", 10, 10, 10, 10, 60, true, "I just love pooping", "fecesphile", 10, 10);
    Review rev6 = new Review("Sixth", 1, 1, 1, 1, 1, false, "I enjoy nothing in life", "girl", 1, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Restrooms");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restroom_list);

        // Get the ListView associated with layout
        restroomList = (ListView) findViewById(R.id.listView);
        // / Create our adaptor and associate ArrayList
        restrooms = new ArrayList<Restroom>();
        adaptor = new RestroomAdaptor(this, restrooms);
        // Associate adapter with ListView
        restroomList.setAdapter(adaptor);

        restrooms.add(r1);
        restrooms.add(r2);
        restrooms.add(r3);
        restrooms.add(r4);

        r1.addReview(rev1);
        r1.addReview(rev3);

        r2.addReview(rev2);
        r2.addReview(rev6);
        r2.addReview(rev3);

        r3.addReview(rev5);

        r4.addReview(rev1);
        r4.addReview(rev1);
        r4.addReview(rev2);
        r4.addReview(rev3);
        r4.addReview(rev4);
        r4.addReview(rev5);
        r4.addReview(rev6);
    }

    // called when a list item is pressed
    public void viewRestroom(View v){
        Restroom restroom = restrooms.get(restroomList.indexOfChild(v));
        Intent i = new Intent(this, ViewRestroomActivity.class);
        i.putExtra("restroom", restroom);
        startActivity(i);
    }
}
