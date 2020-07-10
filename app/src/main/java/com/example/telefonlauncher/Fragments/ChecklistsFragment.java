package com.example.telefonlauncher.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telefonlauncher.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChecklistsFragment extends Fragment {


    View v;
    EditText editTextBreakfast; EditText editTextDinner; EditText editTextSupper; EditText editTextWorkout1; EditText editTextWorkout2;
    EditText editTextWorkoutTime1; EditText editTextWorkoutTime2;
    CheckBox checkBoxBreakfast; CheckBox checkBoxDinner; CheckBox checkBoxSupper; CheckBox checkBoxWorkout1; CheckBox checkBoxWorkout2;

    public static final String SHARED_PREFS ="sharedPrefs";
    public static final String TEXT_BREAKFAST = "text";
    public static final String TEXT_WORKOUT1 = "workout1";
    public static final String CHECKBOX_BREAKFAST = "checkbox";
    public static final String CHECKBOX_WORKOUT1 = "checkbox3";

    private String textBreakfast; private String textDinner; private String textSupper; private String textWorkout1; private String textWorkout2;
        private String textWorkoutTime1; private String textWorkoutTime2;
    private boolean checkboxBreakfastOnOff; private boolean checkboxDinnerOnOff; private boolean checkboxSupperOnOff;
        private boolean checkboxWorkout1OnOff; private boolean checkboxWorkout2OnOff;

    int a = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v =  inflater.inflate(R.layout.fragment_checklists, container, false);


        editTextBreakfast = v.findViewById(R.id.edit_text_breakfast);
        checkBoxBreakfast = v.findViewById(R.id.checkBoxBreakfast);
        editTextWorkout1 = v.findViewById(R.id.edit_text_workout1);
        checkBoxWorkout1 = v.findViewById(R.id.checkBoxWorkout1);



        final Button applyButton = v.findViewById(R.id.apply_button);
        final Button deleteButton = v.findViewById(R.id.delete_button);


        editTextWorkout1.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editTextWorkout1.setRawInputType(InputType.TYPE_CLASS_TEXT);


        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteData();
            }
        });

        loadData();
        updateViews();

        return v;

    }

    public void saveData() {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();

        editor.putString(TEXT_BREAKFAST, editTextBreakfast.getText().toString());

        editor.putBoolean(CHECKBOX_BREAKFAST, checkBoxBreakfast.isChecked());

        editor.putString(TEXT_WORKOUT1, editTextWorkout1.getText().toString());
        editor.putBoolean(CHECKBOX_WORKOUT1, checkBoxWorkout1.isChecked());

        editor.apply();
        Toast.makeText(this.getActivity(), "Data updated", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        textBreakfast = sharedPreferences.getString(TEXT_BREAKFAST, "");

        checkboxBreakfastOnOff = sharedPreferences.getBoolean(CHECKBOX_BREAKFAST, false);

        textWorkout1 = sharedPreferences.getString(TEXT_WORKOUT1, "");
        checkboxWorkout1OnOff = sharedPreferences.getBoolean(CHECKBOX_WORKOUT1, false);

    }

    public void updateViews() {

        editTextBreakfast.setText(textBreakfast);

        checkBoxBreakfast.setChecked(checkboxBreakfastOnOff);

        editTextWorkout1.setText(textWorkout1);
        checkBoxWorkout1.setChecked(checkboxWorkout1OnOff);
    }

    public void deleteData() {

        editTextBreakfast.setText("");
        editTextWorkout1.setText("");
        checkBoxBreakfast.setChecked(false);
        checkBoxWorkout1.setChecked(false);
        saveData();
        loadData();
        updateViews();
    }


}
