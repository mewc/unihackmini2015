package m.unihackmini;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tim_000 on 4/9/2016.
 */
public class ReviewAdaptor extends BaseAdapter{
    private Context context;
    private ArrayList<Review> reviews = new ArrayList<>();

    public ReviewAdaptor(Context context, ArrayList<Review> reviews){
        this.context = context;
        this.reviews = reviews;
    }

    public static class ViewHolder {

    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Review getItem(int i){
        return reviews.get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        ViewHolder vh;
/*
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
            view.setTag(vh);
        } else {
            // View has already been created, fetch our ViewHolder
            vh = (ViewHolder) view.getTag();
        }
        // Assign values to the TextViews using the Restroom object
        vh.restroomName.setText(reviews.get(i).getName());
        vh.restroomRating.setText(Double.toString(reviews.get(i).getAverageRating()));
        /*
        // Change the colour depending on the monster type
        String monsterType = monsters.get(i).getType();
        if (monsterType.equals("Good"))
            vh.attackPower.setTextColor(Color.parseColor("#00FF00")); // Green
        if (monsterType.equals("Neutral"))
            vh.attackPower.setTextColor(Color.parseColor("#0000FF")); // Blue
        if (monsterType.equals("Evil"))
            vh.attackPower.setTextColor(Color.parseColor("#FF0000")); // Red
            */
        // Return the completed View of the row being processed
        return view;
    }
}
