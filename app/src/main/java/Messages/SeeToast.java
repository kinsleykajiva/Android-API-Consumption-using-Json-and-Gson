package Messages;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kinsley kajiva on 6/28/2016.Zvaganzirwa nakinsley kajiva musiwa 6/28/2016
 */
public class SeeToast {




    public static final int LENGTH_SHORT = 1000;
    public static final int LENGTH_LONG = 2000;
    public static final int GRAVITY_TOP = 1;
    public static final int GRAVITY_CENTER = 2;
    public static final int GRAVITY_BOTTOM = 3;

    public void message_long(Context cxt, String string ){
        Toast toast=Toast.makeText(cxt, string, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
    public void message_short(Context cxt, String string ){
        Toast toast=Toast.makeText(cxt, string, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }
    //Show error message with duration
    public static void showError(Context context,String text,int duration,int gravity){
        buildToast(context, text, duration, Color.parseColor("#CC0000"),gravity);
    }
    //Show error message
    public static void showError(Context context,String text,int gravity){
        if(gravity == LENGTH_LONG || gravity == LENGTH_SHORT){
            buildToast(context, text, gravity,Color.parseColor("#CC0000"),gravity);
        }else{
            buildToast(context, text, Toast.LENGTH_SHORT,Color.parseColor("#CC0000"),gravity);
        }
    }
    //Show success message with duration
    public static void showSuccess(Context context,String text,int duration,int gravity){
        buildToast(context, text, duration,Color.parseColor("#669900"),gravity);
    }

    //Show success message
    public static void showSuccess(Context context,String text,int gravity){
        if(gravity == LENGTH_LONG || gravity == LENGTH_SHORT){
            buildToast(context, text, gravity,Color.parseColor("#669900"),gravity);
        }else{
            buildToast(context, text, Toast.LENGTH_SHORT,Color.parseColor("#669900"),gravity);
        }

    }
    //Build ToastMsg for normal view
    private static void buildToast(Context context,String text,int duration,int color,int gravity){
        Toast toast = new Toast(context);
        toast.setView(normalView(context,text,color));
        switch (gravity) {
            case GRAVITY_TOP:
                toast.setGravity(Gravity.TOP|Gravity.LEFT|Gravity.FILL_HORIZONTAL, 0, 0);
                break;
            case GRAVITY_CENTER:
                toast.setGravity(Gravity.LEFT|Gravity.FILL_HORIZONTAL, 0, 0);
                break;
            case GRAVITY_BOTTOM:
                toast.setGravity(Gravity.BOTTOM|Gravity.LEFT|Gravity.FILL_HORIZONTAL, 0, 0);
                break;
            default:
                toast.setGravity(Gravity.TOP|Gravity.LEFT|Gravity.FILL_HORIZONTAL, 0, 0);
                break;
        }
        toast.setMargin(0f,0f);
        toast.setDuration(duration);
        toast.show();
    }
    //Create normal view layout for toast
    private static View normalView(Context context, String text, int color){

        RelativeLayout.LayoutParams params =  new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);


        RelativeLayout layout = new RelativeLayout(context);
        layout.setBackgroundColor(color);
        layout.setPadding(15, 10, 15, 10);
        layout.setGravity(Gravity.TOP);
        layout.setLayoutParams(params);


        TextView textMessge =  new TextView(context);
        textMessge.setText(text);
        textMessge.setTextColor(Color.WHITE);
        layout.addView(textMessge);

        return layout;
    }
}
