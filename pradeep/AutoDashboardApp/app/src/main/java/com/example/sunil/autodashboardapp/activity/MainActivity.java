package com.example.sunil.autodashboardapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.example.sunil.autodashboardapp.R;
import com.example.sunil.autodashboardapp.fragment.HomeFragment;


public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for hiding status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new HomeFragment()); //by default loading Home fragment
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_back:
                    Intent launchNavigation = getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchNavigation != null){
                        Log.d("\nHomeAPP", "onNavigationItemSelected: \n");
                        startActivity(launchNavigation);
                    }
                    else{
                        Log.d("\nHomeAPP", "Navigation App is NULL\n");
                    }
                    return true;
                case R.id.navigation_call:
                    Intent launchCallApp = getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchCallApp != null){
                        Log.d("\nHomeAPP", "onNavigationItemSelected: \n");
                        startActivity(launchCallApp);
                    }
                    else{
                        Log.d("\nHomeAPP", "Call App is NULL\n");
                    }
                    return true;
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_audio:
                    Intent jockeyApp = getPackageManager().getLaunchIntentForPackage("com.marverenic.music.debug");
                    if (jockeyApp != null){
                        Log.d("\nHomeAPP", "onNavigationItemSelected: \n");
                        startActivity(jockeyApp);
                    }
                    else{
                        Log.d("\nHomeAPP", "Jockey App is NULL\n");
                    }
                    return true;

                case R.id.navigation_time:
                    Intent launchInstrumentCluster = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                    if (launchInstrumentCluster != null){
                        Log.d("\nHomeAPP", "onNavigationItemSelected: \n");
                        startActivity(launchInstrumentCluster);
                    }
                    else{
                        Log.d("\nHomeAPP", "Cluster App is NULL\n");
                    }
                    return true;

            }
            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
