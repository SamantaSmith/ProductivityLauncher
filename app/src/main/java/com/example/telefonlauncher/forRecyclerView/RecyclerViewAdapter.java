package com.example.telefonlauncher.forRecyclerView;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.telefonlauncher.R;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    ArrayList<SingleItem> arrayList;
    Context context;


    public RecyclerViewAdapter(ArrayList<SingleItem> arrayList, Context context) {

        this.arrayList = arrayList;
        this.context = context;

    }


    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;
        public int backgroundColor;
        public LinearLayout lLayout;
        public CheckBox checkBox;



        public Holder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textView = itemView.findViewById(R.id.text);
            checkBox = itemView.findViewById(R.id.checkbox);
            lLayout = itemView.findViewById(R.id.lLayout);

            this.setIsRecyclable(false);

        }

        @Override
        public void onClick(View v) {

        }
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_element, parent, false);

        Holder holder = new Holder(view);
        return holder;
    }

    private SparseBooleanArray mCheckedItems = new SparseBooleanArray();

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.Holder holder, final int position) {

        SingleItem singleItem = arrayList.get(position);
        holder.textView.setText(singleItem.getMainText());
        holder.backgroundColor = singleItem.getBackgroundColor();


        holder.textView.setTextSize(15);
        holder.textView.setTextColor(ContextCompat.getColor(context, R.color.silver));


        if (holder.backgroundColor == 2) {holder.lLayout.setBackgroundResource(R.color.forMainLayout);}

        holder.checkBox.setChecked(mCheckedItems.get(position));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = holder.getAdapterPosition();
                final boolean newValue = !(holder.checkBox.isChecked());

                mCheckedItems.put(position, newValue);

            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
