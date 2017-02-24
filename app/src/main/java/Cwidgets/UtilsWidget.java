package Cwidgets;

/**
 * Created by kinsley kajiva on 8/9/2016.Zvaganzirwa nakinsley kajiva musiwa 8/9/2016
 */

import android.content.Context;
import android.content.res.TypedArray;

import kinsleykajiva.co.zw.feed.R;


public class UtilsWidget {

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

    public static int getTabsHeight(Context context) {
        return (int) context.getResources().getDimension(R.dimen.tabsHeight);
    }
}
