package com.example.telefonlauncher.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telefonlauncher.R;

public class TyankaFragment extends Fragment {

    TextView tyankaText;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.fragment_tyanka, container, false);
        tyankaText = v.findViewById(R.id.text_tyanka);
        tyankaText.setText("Привет, солнце! Вот твоя парадигма на сегодня: \n\n1. Без твича и ютуба\n2. Без ставок\n3. Без игр");
        return v;
    }
}
