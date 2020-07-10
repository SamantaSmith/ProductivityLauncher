package com.example.telefonlauncher.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telefonlauncher.AppsActivity;
import com.example.telefonlauncher.R;
import com.example.telefonlauncher.forRecyclerView.RecyclerViewAdapter;
import com.example.telefonlauncher.forRecyclerView.SingleItem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FoodworkFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    View v;

    TextView paradigmaTextNew;
    ImageButton slImageNew;

    EditText editTextNotes;
    private String textNotes;
    public static final String SHARED_PREFS_NOTES = "spNotes";
    public static final String TEXT_NOTES = "notos";
    Button applyNotesButton;

    ImageView zenmoneyLink; ImageView picoocLink; ImageView focusLink; ImageView todoLink; ImageView calendarLink;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_foodwork, container, false);

        final RecyclerView recyclerView = v.findViewById(R.id.recycler);
        ImageView daytimeImage = v.findViewById(R.id.daytimeButton);
        TextView daytimeText = v.findViewById(R.id.daytime_checktext);
        paradigmaTextNew = v.findViewById(R.id.paradigma_text_new);
        slImageNew = v.findViewById(R.id.sl_image_new);
        editTextNotes = v.findViewById(R.id.et_notes);


        zenmoneyLink = v.findViewById(R.id.zenmoney_button);
        picoocLink = v.findViewById(R.id.picooc_button);
        focusLink = v.findViewById(R.id.focus_button);
        todoLink = v.findViewById(R.id.todo_button);
        calendarLink = v.findViewById(R.id.calendar_button);

        applyNotesButton = v.findViewById(R.id.apply_notes_button);

        paradigmaTextNew.setText("Вот твоя парадигма на сегодня: \n\n1. Без твича и ютуба\n2. Без ставок\n3. Без игр");
        slImageNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AppsActivity.class);
                startActivity(intent);
            }
        });



        final ArrayList<SingleItem> singleItems = new ArrayList<>();
        final ArrayList<SingleItem> singleItemsNight = new ArrayList<>();

        singleItems.add(new SingleItem("Взвеситься", 1));
        singleItems.add(new SingleItem("Пробежаться", 1));
        singleItems.add(new SingleItem("Выпить витаминку и кофеин", 1));
        singleItems.add(new SingleItem("Умыться с мылом", 1));


        singleItemsNight.add(new SingleItem("Проверить финансы", 2));
        singleItemsNight.add(new SingleItem("Заполнить дневник", 2));
        singleItemsNight.add(new SingleItem("Заполнить лаунчер", 2));
        singleItemsNight.add(new SingleItem("Записать блоки занятий в Focus", 2));
        singleItemsNight.add(new SingleItem("Умыться с мылом, зубки", 2));


        Date currentDate = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String timeHours = timeFormat.format(currentDate);
        int a = Integer.parseInt(timeHours);

        if (a>=4 && a<=12) {

            RecyclerViewAdapter adapter = new RecyclerViewAdapter(singleItems, getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
            daytimeImage.setImageResource(R.drawable.sun);
            daytimeText.setText("");

        }

        if (a>=16 && a<=23) {

            RecyclerViewAdapter adapter = new RecyclerViewAdapter(singleItemsNight, getActivity());
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
            daytimeImage.setImageResource(R.drawable.night);
            daytimeText.setText("");
        }

        if (a>12 && a<16) {

            daytimeImage.setImageResource(R.drawable.routine);
            daytimeText.setText("");
        }

        applyNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();
        updateViews();

        focusLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.superelement.pomodoro");
                startActivity(intent);
            }
        });

        zenmoneyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("ru.zenmoney.androidsub");
                startActivity(intent);
            }
        });

        picoocLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.picooc.international");
                startActivity(intent);
            }
        });

        todoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage("com.microsoft.todos");
                startActivity(intent);
            }
        });

        calendarLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AppsActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    public void saveData() {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS_NOTES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT_NOTES, editTextNotes.getText().toString());
        editor.apply();
        Toast.makeText(this.getActivity(), "Утверждено", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS_NOTES, Context.MODE_PRIVATE);
        textNotes = sharedPreferences.getString(TEXT_NOTES, "");
    }

    public void updateViews() {

        editTextNotes.setText(textNotes);
    }

}
