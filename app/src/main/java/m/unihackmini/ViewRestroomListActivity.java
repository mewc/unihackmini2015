package m.unihackmini;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewRestroomListActivity extends AppCompatActivity {
    // Unique identifier for receiving activity result
    public static final int ADD_RESTROOM_REQUEST = 1;
    public static final int ADD_REVIEW_REQUEST = 2;

    private ListView restroomList;
    private RestroomAdaptor adaptor;
    private ArrayList<Restroom> restrooms;

    // for testing
    Restroom r1 = new Restroom("R1", "Here", 3, true);
    Restroom r2 = new Restroom("R2", "There", 1, false);
    Restroom r3 = new Restroom("R3", "Under", 2, true);
    Restroom r4 = new Restroom("R4", "Over", 3, false);

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
    }

    // called when a list item is pressed
    public void viewRestroom(View v){
        Intent i = new Intent(this, ViewRestroomListActivity.class);
        startActivity(i);
    }
}
