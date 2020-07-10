package com.example.telefonlauncher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.telefonlauncher.Fragments.AppsListenFragment;
import com.example.telefonlauncher.Fragments.AppsSocialFragment;
import com.example.telefonlauncher.Fragments.AppsUtilsFragment;
import com.example.telefonlauncher.Fragments.WorkblocksFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppsActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps);







        Log.d("MYDEBUG", "create");


        creatingLinks();

        final BottomNavigationView aaNav = findViewById(R.id.aa_bnav);
        aaNav.setOnNavigationItemSelectedListener(listener);

        getSupportFragmentManager().beginTransaction().replace(R.id.apps_container, new AppsListenFragment()).commit();
        aaNav.setSelectedItemId(R.id.nav_aa_listen);



    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onRestart();
    }

    public void creatingLinks() {






    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch(item.getItemId()) {

                case R.id.nav_aa_listen:
                    selectedFragment = new AppsListenFragment();
                    break;
                case R.id.nav_aa_social:
                    selectedFragment = new AppsSocialFragment();
                    break;
                case R.id.nav_aa_utils:
                    selectedFragment = new AppsUtilsFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.apps_container, selectedFragment).commit();
            return true;
        }
    };


}
