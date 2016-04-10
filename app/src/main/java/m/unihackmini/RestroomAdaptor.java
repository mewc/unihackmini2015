package m.unihackmini;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Tim_000 on 4/9/2016.
 */
public class RestroomAdaptor extends BaseAdapter{
    private Context context;
    private ArrayList<Restroom> restrooms = new ArrayList<>();

    public RestroomAdaptor(Context context, ArrayList<Restroom> restrooms){
        this.context = context;
        this.restrooms = restrooms;
    }

    public static class ViewHolder {
        TextView restroomName;
        // ImageView restroomImage;
        TextView restroomRating;
        TextView restroomLocation;
    }

    @Override
    public int getCount() {
        return restrooms.size();
    }

    @Override
    public Restroom getItem(int i){
        return restrooms.get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder vh;

        // Check if view has been created for the row. If not, lets inflate it
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Reference list item layout here
            view = inflater.inflate(R.layout.list_restroom_item, null);
            // Setup ViewHolder and attach to view
            vh = new ViewHolder();
            vh.restroomName = (TextView) view.findViewById(R.id.restroomName);
            vh.restroomRating = (TextView) view.findViewById(R.id.restroomRating);
            vh.restroomLocation = (TextView) view.findViewById(R.id.restroomLocation);
            view.setTag(vh);
        } else {
            // View has already been created, fetch our ViewHolder
            vh = (ViewHolder) view.getTag();
        }
        // Assign values to the TextViews using the Restroom object
        String name = restrooms.get(i).getName();
        double aveRate = restrooms.get(i).getAverageRating();
        String location = restrooms.get(i).getLocation();

        vh.restroomName.setText(name);
        vh.restroomRating.setText((Double.toString(Math.round(aveRate*10)/10.0)));
        vh.restroomLocation.setText(location);

        // Change the colour depending on the monster type
        if (aveRate >= 0)
            vh.restroomRating.setTextColor(Color.parseColor("#FF0000")); // Red
        if (aveRate >= 4)
            vh.restroomRating.setTextColor(Color.parseColor("#0000FF")); // Blue
        if (aveRate >= 7)
            vh.restroomRating.setTextColor(Color.parseColor("#00FF00")); // Green

        // Return the completed View of the row being processed
        return view;
    }
}
