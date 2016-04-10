package m.unihackmini;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewRestroomActivity extends AppCompatActivity {

    private Restroom currentRestroom;
    private TextView nameLabel;
    private TextView locationLabel;
    private TextView genderLabel;
    private TextView disabledLabel;
    private TextView ratingLabel;
    private TextView cleanlinessLabel;
    private TextView modernityLabel;
    private TextView tpLabel;
    private TextView dryerLabel;
    private TextView wifiLabel;
    private TextView odorLabel;
    private TextView trafficLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_restroom);

        // setup UI elements
        nameLabel = (TextView) findViewById(R.id.nameLabel);
        locationLabel = (TextView) findViewById(R.id.locationLabel);
        genderLabel = (TextView) findViewById(R.id.genderLabel);
        disabledLabel = (TextView) findViewById(R.id.disabledLabel);
        ratingLabel = (TextView) findViewById(R.id.ratingLabel);
        cleanlinessLabel = (TextView) findViewById(R.id.cleanlinessLabel);
        modernityLabel = (TextView) findViewById(R.id.modernityLabel);
        tpLabel = (TextView) findViewById(R.id.tpLabel);
        dryerLabel = (TextView) findViewById(R.id.dryerLabel);
        wifiLabel = (TextView) findViewById(R.id.wifiLabel);
        odorLabel = (TextView) findViewById(R.id.odorLabel);
        trafficLabel = (TextView) findViewById(R.id.trafficLabel);

        // get intent
        Intent i = getIntent();
        currentRestroom = i.getParcelableExtra("restroom");

        setTitle(currentRestroom.getName());
        nameLabel.setText(currentRestroom.getName());
        locationLabel.setText("Location: " + currentRestroom.getLocation());

        String genderString = "Unspecified gender bathroom";
        int gender = currentRestroom.getGender();
        switch (gender) {
            case 1:
                genderString = "Male bathroom";
                break;
            case 2:
                genderString = "Female bathroom";
                break;
            case 3:
                genderString = "Unisex bathroom";
                break;
        }
        genderLabel.setText(genderString);
        disabledLabel.setText((currentRestroom.getHasDisabled() ? "Handicap accessible" : "Not handicap accessible"));
        dryerLabel.setText("Dryer: " + currentRestroom.getDryer());
        wifiLabel.setText((currentRestroom.isWifi() ? "WiFi accessible" : "No Wifi. Sorry bud."));

        Double aveRate = currentRestroom.getAverageRating();
        ratingLabel.setText("Overall: " + Double.toString(Math.round(aveRate * 10) / 10.0));
        setColor(ratingLabel, aveRate);

        aveRate = currentRestroom.getAverageCleanliness();
        cleanlinessLabel.setText("Cleanliness: " + Double.toString(Math.round(aveRate * 10) / 10.0));
        setColor(cleanlinessLabel, aveRate);

        aveRate = currentRestroom.getAverageModernity();
        modernityLabel.setText("Modernity: " + Double.toString(Math.round(aveRate * 10) / 10.0));
        setColor(modernityLabel, aveRate);

        aveRate = currentRestroom.getAverageTP();
        tpLabel.setText("Toilet Paper Abundance: " + Double.toString(Math.round(aveRate * 10) / 10.0));
        setColor(tpLabel, aveRate);

        aveRate = currentRestroom.getAverageOdor();
        odorLabel.setText("Odor Pleasantness: " + Double.toString(Math.round(aveRate * 10) / 10.0));
        setColor(odorLabel, aveRate);

        aveRate = currentRestroom.getAverageTraffic();
        trafficLabel.setText("Traffic: " + Double.toString(Math.round(aveRate * 10) / 10.0));
        setColor(trafficLabel, aveRate);
    }

    // sets color based on value
    private void setColor(TextView label, double aveRate){
        if (aveRate >= 0)
            label.setTextColor(Color.parseColor("#FF0000")); // Red
        if (aveRate >= 4)
            label.setTextColor(Color.parseColor("#0000FF")); // Blue
        if (aveRate >= 7)
            label.setTextColor(Color.parseColor("#00a600")); // Green
    }

    public void addReview(View v){
        Restroom restroom = currentRestroom;
        Intent i = new Intent(this, AddReviewActivity.class);
        i.putExtra("restroom", restroom);
        startActivity(i);
    }
}
