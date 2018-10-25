package com.example.sunil.autodashboardapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import com.example.sunil.autodashboardapp.R;
import com.example.sunil.autodashboardapp.app.CustomGrid;



public class HomeFragment extends Fragment {
    GridView grid;
    int[] imageId = {
            R.drawable.fe,
            R.drawable.gal,
            R.drawable.loc,
            R.drawable.set,
            R.drawable.sep,
            R.drawable.mov,
            R.drawable.mus,
            R.drawable.web };
    String[] web = {
            "file",
            "gallery",
            "map",
            "settings",
            "meter",
            "mov",
            "mus",
            "web",

    } ;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        CustomGrid adapter = new CustomGrid(this.getActivity(),imageId);
        grid = v.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(getActivity(), "You Clicked at " +web[+ position] , Toast.LENGTH_SHORT).show();

                if(web[position].equals("web"))
                {
                    Intent launchBrowser = getActivity().getPackageManager().getLaunchIntentForPackage("com.android.chrome");
                    if (launchBrowser != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchBrowser);
                    }
                    else{
                        Log.d("\nHomeAPP", "Browser App is NULL\n");
                    }
                }else
                if(web[position].equals("map"))
                {
                    Intent launchNavigation = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchNavigation != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchNavigation);
                    }
                    else{
                        Log.d("\nHomeAPP", "Navigation App is NULL\n");
                    }

                }
                if(web[position].equals("file"))
                {
                    Intent launchFile = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchFile != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchFile);
                    }
                    else{
                        Log.d("\n\nHomeAPP", "File App is NULL\n");
                    }
                }

                if(web[position].equals("gallery"))
                {
                    Intent launchGallery = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchGallery != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchGallery);
                    }
                    else{
                        Log.d("\nHomeAPP", "Gallery App is NULL\n");
                    }
                }

                if(web[position].equals("mus"))
                {
                    Intent jockeyApp = getActivity().getPackageManager().getLaunchIntentForPackage("com.marverenic.music.debug");
                    if (jockeyApp != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(jockeyApp);
                    }
                    else{
                        Log.d("\nHomeAPP", "Audio App is NULL\n");
                    }
                }
                if(web[position].equals("settings"))
                {
                    Intent launchSettings = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchSettings != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchSettings);
                    }
                    else{
                        Log.d("\nHomeAPP", "Settings App is NULL\n");
                    }
                }
                if(web[position].equals("mov"))
                {
                    Intent launchVideo = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                    if (launchVideo != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchVideo);
                    }
                    else{
                        Log.d("\nHomeAPP", "Video App is NULL\n");
                    }
                }
                if(web[position].equals("meter"))
                {
                    Intent launchInstrumentCluster = getActivity().getPackageManager().getLaunchIntentForPackage("com.example.sunil.sampleapp");
                    if (launchInstrumentCluster != null){
                        Log.d("\nHomeAPP", "onIconSelected: \n");
                        startActivity(launchInstrumentCluster);
                    }
                    else{
                        Log.d("\nHomeAPP", "Cluster App is NULL\n");
                    }
                }
            }
        });
        return v;

    }

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
