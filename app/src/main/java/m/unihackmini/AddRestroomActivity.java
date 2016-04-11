package m.unihackmini;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddRestroomActivity extends AppCompatActivity {

    private String[] arraySpinner;
    private EditText inputName;
    private EditText inputLocation;
    private Button createButton;
    private Spinner genderSpinner;
    private CheckBox disabled;
    private EditText dryer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restroom);

        inputName = (EditText) findViewById(R.id.inputName);
        inputLocation = (EditText) findViewById(R.id.inputLocation);

//       final RadioButton male =  (RadioButton) findViewById(R.id.inputMale);
//       final RadioButton female =  (RadioButton) findViewById(R.id.inputFemale);
//       final RadioButton unisex = (RadioButton) findViewById(R.id.inputUnisex);

        createButton = (Button) findViewById(R.id.createRestroomButton);
        genderSpinner = (Spinner) findViewById(R.id.inputGender);
        disabled = (CheckBox) findViewById(R.id.inputDisabled);
        dryer = (EditText) findViewById(R.id.inputDryer);
        setTitle("Add Restroom");


        arraySpinner = new String[] {
                "Male", "Female", "Unisex"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        genderSpinner.setAdapter(adapter);

        /*
        View.OnClickListener radioListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if((v.getId() == ){
                    enableCreateButton();
                }
            }
        };

        male.setOnClickListener(radioListener);
        female.setOnClickListener(radioListener);
        unisex.setOnClickListener(radioListener);
*/

    }





    public void enableCreateButton() {
        Button c = (Button) findViewById(R.id.createRestroomButton);
        c.setBackgroundColor(Color.parseColor("BLUE"));
        c.setEnabled(true);
    }

    public void createRestroom(View v){
        String name = inputName.getText().toString();
        String location = inputLocation.getText().toString();
        int gender = (int) (genderSpinner.getSelectedItemPosition()) +1;
        boolean isDisabled = disabled.isChecked();
        String dryer = this.dryer.getText().toString();

        Restroom r  = new Restroom(name, location, gender, isDisabled, dryer);

        //Intent i = new Intent(this, )

        MainActivity m = new MainActivity();

        m.getR().add(r);

        Context context = getApplicationContext();
        CharSequence text = r.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent i = new Intent(this, AddReviewActivity.class);
        i.putExtra("restroom", r);
        startActivity(i);

    }

}
