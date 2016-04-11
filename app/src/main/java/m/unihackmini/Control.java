package m.unihackmini;

import java.util.ArrayList;

/**
 * Created by Tim_000 on 4/10/2016.
 */
public class Control {
    public static ArrayList<Restroom> restroomListGlobal = new ArrayList<>();

    public Control() {
    }

    public static ArrayList<Restroom> getRestroomListGlobal() {
        return restroomListGlobal;
    }
}
