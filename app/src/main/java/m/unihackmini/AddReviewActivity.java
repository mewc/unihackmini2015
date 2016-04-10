package m.unihackmini;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;

public class AddReviewActivity extends AppCompatActivity {

    private Restroom currentRestroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        Intent i = getIntent();
        currentRestroom = i.getParcelableExtra("restroom");
        setTitle("Add Review: " + currentRestroom.getName());
    }

    public void submit(View v){
        RatingBar overall = (RatingBar) findViewById(R.id.overalRate);
        RatingBar clean = (RatingBar) findViewById(R.id.cleanlinessRate);
        RatingBar modern = (RatingBar) findViewById(R.id.modernityRate);
        RatingBar odor = (RatingBar) findViewById(R.id.odorRate);
        RatingBar toiletP = (RatingBar) findViewById(R.id.tpRate);
        RatingBar traffic = (RatingBar) findViewById(R.id.trafficRate);

        CheckBox wifi = (CheckBox) findViewById(R.id.checkBox);

        int r = (int)overall.getRating()*2;
        int c = (int)clean.getRating()*2;
        int m = (int)modern.getRating()*2;
        int tr = (int)traffic.getRating()*2;
        int tp = (int)toiletP.getRating()*2;
        int o = (int)odor.getRating()*2;
        boolean w = wifi.isChecked();
        currentRestroom.addReview(new Review("", r, c, m, tr, 0, w, "", "", tp, o));

        Intent i = new Intent(this, ViewRestroomActivity.class);
        i.putExtra("restroom", currentRestroom);
        startActivity(i);
    }
}
