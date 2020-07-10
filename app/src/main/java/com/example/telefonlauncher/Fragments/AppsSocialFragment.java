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

public class AppsSocialFragment extends Fragment {

    View v;
    TextView vkMe;
    TextView telegram;
    TextView whatsApp;
    TextView messages;
    TextView telefon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_apps_social, container, false);

        vkMe = v.findViewById(R.id.vk_me);
        telegram = v.findViewById(R.id.telegram);
        whatsApp = v.findViewById(R.id.whatsapp);
        messages = v.findViewById(R.id.messages);
        telefon = v.findViewById(R.id.telefon);

        vkMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4 = getActivity().getPackageManager().getLaunchIntentForPackage("com.vk.im");
                if (intent4 != null) {

                    startActivity(intent4);
                }
            }
        });

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent5 = getActivity().getPackageManager().getLaunchIntentForPackage("org.telegram.messenger");
                if (intent5 != null) {

                    startActivity(intent5);
                }
            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.apps.messaging");
                startActivity(intent);
            }
        });

        whatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                startActivity(intent);
            }
        });

        telefon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.google.android.dialer");
                startActivity(intent);
            }
        });

        return v;
    }
}
