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

public class AppsListenFragment extends Fragment {

    View v;
    TextView aimp;
    TextView yaMusic;
    TextView boomMusic;
    TextView castBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_apps_listen, container, false);

        aimp = v.findViewById(R.id.aimp);
        boomMusic = v.findViewById(R.id.boom);
        castBox = v.findViewById(R.id.castbox);
        yaMusic = v.findViewById(R.id.yandex_music);

        boomMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.uma.musicvk");
                startActivity(intent);
            }
        });

        castBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("fm.castbox.audiobook.radio.podcast");
                startActivity(intent);
            }
        });

        yaMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("ru.yandex.music");
                startActivity(intent);
            }
        });

        aimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent3 = getActivity().getPackageManager().getLaunchIntentForPackage("com.aimp.player");
                if (intent3 != null) {

                    startActivity(intent3);
                }
            }
        });

        return v;
    }
}
