package com.example.telefonlauncher.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.telefonlauncher.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OverallPlanFoodworkFragment extends Fragment {

    View v;
    MaterialCalendarView workoutCalendar;
    TextView textView;


    public static final String SHARED_PREFS_OPFF = "spopff";
    public static final String TEXT_MONDAY = "monday";
    public static final String TEXT_TUESDAY = "tuesday";
    public static final String TEXT_WEDNESDAY = "wednesday";
    public static final String TEXT_THURSDAY = "thursday";
    public static final String TEXT_FRIDAY = "friday";
    public static final String TEXT_SATURDAY = "saturday";
    public static final String TEXT_SUNDAY = "sunday";

    EditText editTextTraining;
    private String textMonday; private String textTuesday; private String textWednesday;
    private String textThursday; private String textFriday; private String textSaturday;
    private String textSunday;




    TitleFormatter titleFormatter = new TitleFormatter() {
        @Override
        public CharSequence format(CalendarDay day) {
            return "План тренировок";
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_overall_foodwork_plan, container, false);

        textView = v.findViewById(R.id.text_view);
        final Button applyTrainingButton = v.findViewById(R.id.appply_training_button);
        editTextTraining = v.findViewById(R.id.edit_text_training);
        workoutCalendar = v.findViewById(R.id.workout_calendar);
        workoutCalendar.setTitleFormatter(titleFormatter);

        workoutCalendar.setOnDateChangedListener(new OnDateSelectedListener() {

            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                String dataChoosed="";
                textView.setText(String.valueOf(date));

                int r = 0;
                int m = 0;
                String b = "";
                String d = "";
                String y = "";
                String a = String.valueOf(date);
                for (int i = 0; i<a.length()-1; i++) {


                    char c = a.charAt(i);
                    if (r == 0 && m == 1 && c!= '-') {y+=c;}
                    if (r == 1 && c != '-') {d+=c;}
                    if (r == 2) {b+=c;}
                    if (c == '-') {r +=1;}
                    if (c == '{') {m+=1;}

                }


                if (b.length() == 1) {b = '0' + b;}
                if (d.length() == 1) {d = '0' + d;}
                dataChoosed = (b + "/" + d + "/" + y);

                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                Date date1 = null;
                try {
                    date1 = format1.parse(dataChoosed);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                DateFormat format2 = new SimpleDateFormat("EEEE");
                String finalDay = format2.format(date1);

                textView.setText(finalDay);
                int dayDay = transformDayNameToNumber(finalDay);




                Toast.makeText(getActivity(), textTuesday, Toast.LENGTH_SHORT).show();

            }
        });



        applyTrainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int a = transformDayNameToNumber(textView.getText());
                 saveData(a);
            }
        });


        return v;
    }




    public void saveData(int dayWeek) {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS_OPFF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch (dayWeek) {
            case 1 : editor.putString(TEXT_MONDAY, editTextTraining.getText().toString());
            case 2 : editor.putString(TEXT_TUESDAY, editTextTraining.getText().toString()); Toast.makeText(this.getActivity(), "Data saved", Toast.LENGTH_SHORT).show();
            case 3 : editor.putString(TEXT_WEDNESDAY, editTextTraining.getText().toString());
            case 4 : editor.putString(TEXT_THURSDAY, editTextTraining.getText().toString());
            case 5 : editor.putString(TEXT_FRIDAY, editTextTraining.getText().toString());
            case 6 : editor.putString(TEXT_SATURDAY, editTextTraining.getText().toString());
            case 7 : editor.putString(TEXT_SUNDAY, editTextTraining.getText().toString());

        }
        editor.apply();

    }

    public void loadData(int dayWeek) {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS_OPFF, Context.MODE_PRIVATE);

            switch (dayWeek) {
                case 1: textMonday = sharedPreferences.getString(TEXT_MONDAY, "");
                case 2: textTuesday = sharedPreferences.getString(TEXT_TUESDAY, "");
                case 3: textWednesday = sharedPreferences.getString(TEXT_WEDNESDAY, "");
                case 4: textThursday = sharedPreferences.getString(TEXT_THURSDAY, "");
                case 5: textFriday = sharedPreferences.getString(TEXT_FRIDAY, "");
                case 6: textSaturday = sharedPreferences.getString(TEXT_SATURDAY, "");
                case 7: textSunday = sharedPreferences.getString(TEXT_SUNDAY, "");}



    }

    public void updateViews(int dayWeek) {

        switch (dayWeek) {

            case 1 : editTextTraining.setText(textMonday);
            case 2 : editTextTraining.setText(textTuesday);
            case 3 : editTextTraining.setText(textWednesday);
            case 4 : editTextTraining.setText(textThursday);
            case 5 : editTextTraining.setText(textFriday);
            case 6 : editTextTraining.setText(textSaturday);
            case 7 : editTextTraining.setText(textSunday);

        }
    }

    public int transformDayNameToNumber(CharSequence dayName) {

        int a = 0;
        if ("понедельник".equals(dayName)) {
            a = 1;
        } else if ("вторник".equals(dayName)) {
            a = 2;
        } else if ("среда".equals(dayName)) {
            a = 3;
        } else if ("четверг".equals(dayName)) {
            a = 4;
        } else if ("пятница".equals(dayName)) {
            a = 5;
        } else if ("суббота".equals(dayName)) {
            a = 6;
        } else if ("воскресенье".equals(dayName)) {
            a = 7;
        }

        return a;
    }
}
