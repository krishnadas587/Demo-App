package com.example.demoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapteremp extends RecyclerView.Adapter<adapteremp.viewholder> {
    Context context;
    List<String> datas;
    List<String> posit;

    public adapteremp(Context context, List<String> datas, List<String> posit) {
        this.context = context;
        this.datas = datas;
        this.posit = posit;
    }

    @NonNull
    @Override
    public adapteremp.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.employeerecycle, null, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapteremp.viewholder holder, int position) {
        holder.name.setText(datas.get(position));
        holder.design.setText(posit.get(position));
        holder.img.setBackgroundResource(R.drawable.ic_baseline_image_not_supported_24);
        holder.img.setBackgroundColor(context.getResources().getColor(R.color.purple_200));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,details.class);
                intent.putExtra("selected",holder.name.getText().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ConstraintLayout layout;
        TextView name;
        TextView design;
        ImageView img;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            layout=itemView.findViewById(R.id.fulllay);
            name = itemView.findViewById(R.id.emp_name);
            design = itemView.findViewById(R.id.emp_desig);
            img=itemView.findViewById(R.id.emp_pic);
        }
    }
}
