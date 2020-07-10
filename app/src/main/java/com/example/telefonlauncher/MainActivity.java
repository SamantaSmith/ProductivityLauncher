package com.example.telefonlauncher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.telefonlauncher.Fragments.ChecklistsFragment;
import com.example.telefonlauncher.Fragments.FoodworkFragment;
import com.example.telefonlauncher.Fragments.HomeFragment;
import com.example.telefonlauncher.Fragments.OverallPlanFoodworkFragment;
import com.example.telefonlauncher.Fragments.TyankaFragment;
import com.example.telefonlauncher.Fragments.WorkblocksFragment;
import com.example.telefonlauncher.forRecyclerView.RecyclerViewAdapter;
import com.example.telefonlauncher.forRecyclerView.SingleItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    FrameLayout fragmentTyanka;
    FrameLayout fragmentContainer;


    ImageButton samantaButton;
    TextView dateTextVIew;
    boolean flagFragment = false;
    boolean flagFragment2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }


        setContentView(R.layout.activity_main);

        dateTextVIew = findViewById(R.id.date_textview);
        samantaButton = findViewById(R.id.samanta_button);



        Date currentDate = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String timeHours = timeFormat.format(currentDate);
        int a = Integer.parseInt(timeHours);
        Log.d("MYDEBUG", String.valueOf(a));

        Date currentSprint = new Date();
        DateFormat formatSprint = new SimpleDateFormat("w");
        String sprintFormate = formatSprint.format(currentSprint);
        int sprintInt = Integer.parseInt(sprintFormate);

        if (sprintInt%3 == 1) {

            dateTextVIew.setText("Спринт 2");
        }

        if (sprintInt%3 == 2) {

            dateTextVIew.setText("Спринт 3");
        }

        if (sprintInt%3 == 0) {

            dateTextVIew.setText("Спринт 1");
        }


        Date currentMate = new Date();
        DateFormat format = new SimpleDateFormat("', День' u. EEEE", Locale.US);
        String dateFormate = format.format(currentMate);
        dateTextVIew.append(dateFormate);


        final BottomNavigationView bNav = findViewById(R.id.bottom_navigation);
        bNav.setOnNavigationItemSelectedListener(navListener);

        fragmentContainer = findViewById(R.id.fragment_container);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WorkblocksFragment()).commit();
        bNav.setSelectedItemId(R.id.nav_home);




        /*samantaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AppsActivity.class);
                startActivity(intent);
            }
        });*/




    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            |View.SYSTEM_UI_FLAG_IMMERSIVE);
        }
    }


    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onStop() {
        Log.d("MYDEBUG", "Stopped");

        super.onStop();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch(item.getItemId()) {

                case R.id.nav_home:
                    selectedFragment = new WorkblocksFragment();
                    break;
                case R.id.nav_checklists:
                    selectedFragment = new ChecklistsFragment();

                    break;
                case R.id.nav_foodwork:
                    selectedFragment = new FoodworkFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
