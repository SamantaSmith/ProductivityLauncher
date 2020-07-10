package com.example.telefonlauncher.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telefonlauncher.R;

public class AppsUtilsFragment extends Fragment {

    View v;
    TextView settings;
    TextView sberBank;
    TextView clock;
    TextView nikeRun;
    TextView yaElki;
    TextView profiRu;
    TextView gDrive;
    TextView gMaps;
    TextView moonReader;
    TextView lPlayer;
    TextView notion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_apps_utils, container, false);

        settings = v.findViewById(R.id.settings);
        sberBank = v.findViewById(R.id.sber);
        clock = v.findViewById(R.id.clock);
        nikeRun = v.findViewById(R.id.nike_run);
        yaElki = v.findViewById(R.id.elki);
        profiRu = v.findViewById(R.id.profi);
        gDrive = v.findViewById(R.id.drive);
        gMaps = v.findViewById(R.id.maps);
        moonReader = v.findViewById(R.id.moonreader);
        lPlayer = v.findViewById(R.id.lplayer);
        notion = v.findViewById(R.id.notion);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            }
        });

        sberBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent6 = getActivity().getPackageManager().getLaunchIntentForPackage("ru.sberbankmobile");
                startActivity(intent6);
            }
        });



        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.android.deskclock");
                startActivity(intent);
            }
        });

        nikeRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.nike.plusgps");
                startActivity(intent);
            }
        });


        yaElki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("ru.yandex.rasp");
                startActivity(intent);
            }
        });


        profiRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.profibackoffice.reactnative");
                startActivity(intent);
            }
        });



        gDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.docs");
                startActivity(intent);
            }
        });

        gMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        moonReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.flyersoft.moonreaderp");
                startActivity(intent);
            }
        });

        lPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.helge.lplayer");
                startActivity(intent);
            }
        });

        notion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("notion.id");
                startActivity(intent);
            }
        });
        return v;
    }
}
