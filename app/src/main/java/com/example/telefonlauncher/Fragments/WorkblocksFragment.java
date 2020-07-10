package com.example.telefonlauncher.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telefonlauncher.AppsActivity;
import com.example.telefonlauncher.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WorkblocksFragment extends Fragment {

    View v;

    EditText editTextWorkblocksNew;
    EditText editTextImportantTasksNew;
    private String textWorkblocksNew;
    private String textImportantTasksNew;
    Button applyButtonNew;

    public static final String SHARED_PREFS_MAINSCREEN_NEW = "sharedPrefsMain";
    public static final String TEXT_WORKBLOCKS_NEW = "workblocks";
    public static final String TEXT_TASKS_NEW = "tasks";


    TextView morningChecklist;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_workblocks, container, false);

        editTextWorkblocksNew = v.findViewById(R.id.workblocks_new);
        editTextImportantTasksNew = v.findViewById(R.id.tasks_new);
        applyButtonNew = v.findViewById(R.id.apply_new);
        morningChecklist = v.findViewById(R.id.morningcare);


        applyButtonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();
        updateViews();

        Date currentDate = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String timeHours = timeFormat.format(currentDate);
        int a = Integer.parseInt(timeHours);

        if (a >= 4 && a <= 10) {

            morningChecklist.setVisibility(View.VISIBLE);
            morningChecklist.setText("Утренний чек-лист: \n\n 1. Взвеситься\n" +
                    "2. Выпить кофеин\n 3. Выполнить тренировку по плану\n" +
                    "4. Умыться с мылом");
        } else {

            morningChecklist.setVisibility(View.INVISIBLE);
        }


        return v;
    }

    public void saveData() {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS_MAINSCREEN_NEW, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT_WORKBLOCKS_NEW, editTextWorkblocksNew.getText().toString());
        editor.putString(TEXT_TASKS_NEW, editTextImportantTasksNew.getText().toString());
        editor.apply();
        Toast.makeText(this.getActivity(), "Утверждено", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS_MAINSCREEN_NEW, Context.MODE_PRIVATE);
        textWorkblocksNew = sharedPreferences.getString(TEXT_WORKBLOCKS_NEW, "");
        textImportantTasksNew = sharedPreferences.getString(TEXT_TASKS_NEW, "");

    }

    public void updateViews() {

        editTextWorkblocksNew.setText(textWorkblocksNew);
        editTextImportantTasksNew.setText(textImportantTasksNew);
    }
}
