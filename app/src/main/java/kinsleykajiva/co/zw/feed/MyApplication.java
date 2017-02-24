package kinsleykajiva.co.zw.feed;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by kinsley kajiva on 10/16/2016.Zvaganzirwa nakinsley kajiva musiwa 10/16/2016
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
