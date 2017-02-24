package kinsleykajiva.co.zw.feed;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import Messages.SeeToast;
import fragments.Home;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DrawerLayout drawer;
    private final int INTERNET_PERMISSION = 22;
    private static final String[] PERMISSIONS_INTERNET = new String[]{Manifest.permission.INTERNET};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT > 22) {
            initPermissions();
        }
        initObjects();
        initViews();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new Home())
                    .commit();
        }
        settingViewsValues();
        OnClickListiners();


    }

    private void initPermissions() {
        // ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.INTERNET}, INTERNET_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == INTERNET_PERMISSION) {
            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Displaying a toast
                // Toast.makeText(this,"Permission granted now you can read the storage",Toast.LENGTH_LONG).show();

            } else {
                //Displaying another toast if permission is not granted
                //  Log.e("xxx ", "you just denied the permission ");

                SeeToast.showError(this, "Restart and Allow Permission", SeeToast.GRAVITY_CENTER);
                finish();

            }
        }
    }

    private void settingViewsValues() {


    }

    private void OnClickListiners() {
        fab.setOnClickListener(m ->
                Toast.makeText(MainActivity.this, "Start Download", Toast.LENGTH_SHORT).show()

        );

    }

    private void initObjects() {


    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        HomeKeeping();
    }

    private void HomeKeeping() {


    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            settFragment(new Home());

        } else if (id == R.id.nav_share) {
            settFragment(new Home());
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void settFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_main, fragment);
        ft.commit();
    }
}
