package com.example.telefonlauncher.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telefonlauncher.AppsActivity;
import com.example.telefonlauncher.R;

public class HomeFragment extends Fragment  {


    View v;

    boolean flagDela = false;

    EditText editTextWorkblocks; EditText editTextImportantTasks;
    private String textWorkblocks; private String textImportantTasks;

    public static final String SHARED_PREFS_MAINSCREEN = "sharedPrefsMain";
    public static final String TEXT_WORKBLOCKS = "workblocks";
    public static final String TEXT_TASKS = "tasks";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);






        return v;
    }





}
