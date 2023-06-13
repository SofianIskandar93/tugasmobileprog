package com.project.budgetingapps;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ChildItemAdapter
        extends RecyclerView
        .Adapter<ChildItemAdapter.ChildViewHolder> {

    private List<childitem2> ChildItemList;
    private List<childitem2> childit2;
    private List<childitem2> tanggalchild;
    private String paren;
    Context context;
    
    // Constructor
    ChildItemAdapter(List<childitem2> childItemList, List<childitem2> child, List<childitem2> childt2, Context c,String parent)
    {
        this.ChildItemList = childItemList;
        this.childit2 = child;
        this.tanggalchild = childt2;
        this.context = c;
        this.paren = parent;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(
            @NonNull ViewGroup viewGroup,
            int i)
    {

        // Here we inflate the corresponding
        // layout of the child item
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.row, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ChildViewHolder childViewHolder,
            int position)
    {

        // Create an instance of the ChildItem
        // class for the given position

        childitem2 childItem = ChildItemList.get(position);
        childitem2 child = childit2.get(position);
        childitem2 childtg = tanggalchild.get(position);

        // For the created instance, set title.
        childViewHolder.ChildItemTitle.setText(childItem.getChildItemTitle());
        childViewHolder.child2.setText(child.getChildItemTitle());
        childViewHolder.tanggal.setText(childtg.getChildItemTitle());
    }

    @Override
    public int getItemCount() {
        return ChildItemList.size();
    }

    // This class is to initialize
    // the Views present
    // in the child RecyclerView
    class ChildViewHolder
            extends RecyclerView.ViewHolder {

        TextView ChildItemTitle,tanggal;
        TextView child2;
        Button button;
        dbhelper db;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            db = new dbhelper(context);
            ChildItemTitle = itemView.findViewById(R.id.recviewnama);
            child2 = itemView.findViewById(R.id.recviewjumlah);
            tanggal = itemView.findViewById(R.id.recviewnama2);
            button = itemView.findViewById(R.id.edit);
            Bundle bundle = new Bundle();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bundle.putString("itemid", paren);
                    bundle.putInt("id",getPosition());
                    Intent intent = new Intent(context, edit.class);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });




        }
    }
}
