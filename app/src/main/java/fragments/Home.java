package fragments;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import Adapters.HomeRecyclerAdapter;
import Cwidgets.LinearItermDecorator;
import Cwidgets.MyRecyclerItemClickListener;
import Extras.RecyclerAcross;
import Interface_CallBacks.Interface_loadSatesJsonApi;
import Messages.SeeToast;
import NetWox.NetGet_StatesJsonApi;
import NetWox.netConxn;
import Pojos.States_Api_Json;
import kinsleykajiva.co.zw.feed.R;

/**
 * Created by kinsley kajiva on 10/15/2016.Zvaganzirwa nakinsley kajiva musiwa 10/15/2016
 */
public class Home extends Fragment implements Interface_loadSatesJsonApi {
    private final int ACCESS_NETWORK_STATE_PERMISSION = 23;
    private static final String[] PERMISSIONS_ACCESS_NETWORK_STATE = new String[]{Manifest.permission.ACCESS_NETWORK_STATE};
    private static final String STATE_ROTATE = "state_restore";
    private RecyclerView mRecycler;
    private HomeRecyclerAdapter mAdapter;
    private RecyclerAcross recyclerAcross = new RecyclerAcross();
    private ArrayList<States_Api_Json> myOptions = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.recycler_layout, container, false);
        initObjects();
        initViews(layout);
        SetUp_Online();
        if (savedInstanceState == null) {// is running for the first time
          
            if (Build.VERSION.SDK_INT > 22) {
                initPermissions();
            }
            if (new netConxn(getContext()).is__There_InternetConx()) {
               // SetUp_Online();
                new NetGet_StatesJsonApi(this).execute();
            } else {
               // SetUp_Offline();
            }
        } else { // the screen has been flipped or screen orientation has changed
            myOptions = savedInstanceState.getParcelableArrayList(STATE_ROTATE);
            RecyclerLoaded(myOptions);
        }


        return layout;
    }

    private void SetUp_Offline() {
        SeeToast.showError(getContext(), "running offline", SeeToast.GRAVITY_CENTER);
    }

    private void initPermissions() {
        // ask for the permission
        ActivityCompat.requestPermissions((Activity) getContext(), new String[]{android.Manifest.permission.ACCESS_NETWORK_STATE}, ACCESS_NETWORK_STATE_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == ACCESS_NETWORK_STATE_PERMISSION) {
            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                SeeToast.showError(getContext(), "Restart and Allow Permission", SeeToast.GRAVITY_CENTER);
                getActivity().finish();
            }
        }
    }

    private void SetUp_Online() {

        mAdapter = new HomeRecyclerAdapter(myOptions);
        mRecycler.setAdapter(recyclerAcross.randomRecyclerViewAdapter(mAdapter));
        mRecycler.setHasFixedSize(true);
    }

    private void initViews(View layout) {
        mRecycler = (RecyclerView) layout.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.addItemDecoration(new LinearItermDecorator(getContext(), LinearLayoutManager.VERTICAL));
        mRecycler.setItemAnimator(recyclerAcross.randomItemAnimator());

    }

    private void initObjects() {
    }

private void RecyclerLoaded(ArrayList<States_Api_Json> list){
    this. myOptions=list;
    mAdapter.setitems(list);
    mRecycler.addOnItemTouchListener(new MyRecyclerItemClickListener(getContext(), (view, position) ->

            Toast.makeText(getContext(), "recycler view click event juts been done with lambda expressions", Toast.LENGTH_SHORT).show()

    ));
}
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //save the  list to a parcelable prior to rotation or configuration change
        outState.putParcelableArrayList(STATE_ROTATE, myOptions);


    }

    @Override
    public void onSatesJsonApi_Loaded(ArrayList<States_Api_Json> list) {
        if (list == null) {
            SetUp_Offline();
        } else {
            RecyclerLoaded(list);

        }
    }
}