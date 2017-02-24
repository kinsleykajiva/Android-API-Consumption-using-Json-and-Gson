package Extras;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;

import java.util.Random;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;
import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator;
import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInRightYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by kinsley kajiva on 10/16/2016.Zvaganzirwa nakinsley kajiva musiwa 10/16/2016
 */

public class RecyclerAcross {
    private int SDK_MINIMUM=18;


    public RecyclerView.Adapter randomRecyclerViewAdapter(RecyclerView.Adapter adapter) {
        if (android.os.Build.VERSION.SDK_INT < SDK_MINIMUM) {
            // return new DefaultItemAnimator();
            return adapter;
        } else {

            int randomNum;
            int maximum = 4;
            int minimum = 0;
            randomNum = new Random().nextInt(maximum - minimum + 1) + minimum;

            switch (randomNum) {

                case 1:
                    AlphaInAnimationAdapter ada = new AlphaInAnimationAdapter(adapter);
                    ada.setDuration(2300);
                    return ada;
                case 2:
                    ScaleInAnimationAdapter adat = new ScaleInAnimationAdapter(adapter);
                    adat.setDuration(1000);
                    return adat;
                case 3:
                    SlideInBottomAnimationAdapter adap = new SlideInBottomAnimationAdapter(adapter);
                    adap.setDuration(1000);
                    return adap;
                case 4:
                    SlideInRightAnimationAdapter adax = new SlideInRightAnimationAdapter(adapter);
                    adax.setDuration(2100);
                    return adax;
                case 5:
                    SlideInLeftAnimationAdapter adas = new SlideInLeftAnimationAdapter(adapter);
                    adas.setDuration(2100);
                    return adas;
                default:
                    AlphaInAnimationAdapter adau = new AlphaInAnimationAdapter(adapter);
                    adau.setDuration(1000);
                    return adau;
            }
        }
    }

    public RecyclerView.ItemAnimator randomItemAnimator() {
        if (android.os.Build.VERSION.SDK_INT < SDK_MINIMUM) {
            return new DefaultItemAnimator();

        } else {
            int randomNum;
            int maximum = 22;
            int minimum = 0;
            randomNum = new Random().nextInt(maximum - minimum + 1) + minimum;

            switch (randomNum) {
                case 1:
                    return new ScaleInTopAnimator();
                case 2:
                    return new ScaleInAnimator();
                case 3:
                    return new ScaleInTopAnimator();
                case 4:
                    return new ScaleInBottomAnimator();
                case 5:
                    return new ScaleInLeftAnimator();
                case 6:
                    return new ScaleInRightAnimator();
                case 7:
                    return new FadeInAnimator();
                case 8:
                    return new FadeInDownAnimator();
                case 9:
                    return new FadeInUpAnimator();
                case 10:
                    return new FadeInLeftAnimator();
                case 11:
                    return new FadeInRightAnimator();
                case 12:
                    return new FlipInTopXAnimator();
                case 13:
                    return new FlipInBottomXAnimator();
                case 14:
                    return new FlipInLeftYAnimator();
                case 15:
                    return new FlipInRightYAnimator();
                case 16:
                    return new SlideInLeftAnimator();
                case 17:
                    return new SlideInRightAnimator();
                case 18:
                    return new OvershootInLeftAnimator();
                case 19:
                    return new OvershootInRightAnimator();
                case 20:
                    return new SlideInUpAnimator();
                case 21:
                    return new SlideInDownAnimator();
                case 22:
                    return new LandingAnimator();

                default:
                    return new ScaleInTopAnimator();
            }
        }
    }
}
