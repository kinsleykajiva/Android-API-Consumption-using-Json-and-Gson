package NetWox;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BuildConfigs.Configs;
import Interface_CallBacks.Interface_loadSatesJsonApi;
import Pojos.States_Api_Json;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by kinsley kajiva on 10/16/2016.Zvaganzirwa nakinsley kajiva musiwa 10/16/2016
 */

public class NetGet_StatesJsonApi extends AsyncTask<Void, Void, ArrayList<States_Api_Json>> {
    private Interface_loadSatesJsonApi loadServices;


    public NetGet_StatesJsonApi(Interface_loadSatesJsonApi loadServices) {
        this.loadServices = loadServices;
    }

    @Override
    protected ArrayList<States_Api_Json> doInBackground(Void... params) {
        List<States_Api_Json> op = null;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Configs.STATE_JSON_API)
                .build();


        try {       // remember kinsley you inlined several of breakable functions
           // String jsonResponse = client.newCall(request).execute().body().string();

         //   JSONObject jsonObject = new JSONObject(client.newCall(request).execute().body().string());
          ///  String g = new JSONObject(client.newCall(request).execute().body().string()).getString("seriess");
          //  Log.e("xxx-->", " " + g);
            op = (
                    new Gson().fromJson(
                            new JSONObject(client.newCall(request).execute().body().string()).getString("seriess"),
                            new TypeToken<ArrayList<States_Api_Json>>() {
                            }.getType()
                    )
            );
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return (ArrayList<States_Api_Json>) op;
    }

    @Override
    protected void onPostExecute(ArrayList<States_Api_Json> services_itemses) {
        super.onPostExecute(services_itemses);
        loadServices.onSatesJsonApi_Loaded(services_itemses);
    }



}
