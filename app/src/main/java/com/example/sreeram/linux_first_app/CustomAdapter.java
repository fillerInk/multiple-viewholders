package com.example.sreeram.linux_first_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;



public class CustomAdapter extends RecyclerView.Adapter {

    private ArrayList<DataModel> dataSet;
    Context context;

    public int[] configuration = new int[]{1,0,1,0,0,0,1,0 };

    public static class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        TextView sectionHeader;
        public SectionHeaderViewHolder(View view){
            super(view);
            this.sectionHeader = (TextView) view.findViewById(R.id.sectionHeaderText);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView heading;
        TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.heading = (TextView) itemView.findViewById(R.id.heading);
            this.description = (TextView) itemView.findViewById(R.id.description);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data,Context context){
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        return configuration[position];
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {


        View view;

        switch(viewType){

            case 1 : view = LayoutInflater.from(viewGroup.getContext())
                                                                .inflate(R.layout.section_header_layout,viewGroup,false);
                                                        SectionHeaderViewHolder sectionHeaderViewHolder = new SectionHeaderViewHolder(view);
                                                        return sectionHeaderViewHolder;

            case 0 : view = LayoutInflater.from(viewGroup.getContext())
                                                       .inflate(R.layout.card_layout,viewGroup,false);
                                             MyViewHolder myViewHolder = new MyViewHolder(view);
                                             return myViewHolder;

            default: return null;
        }




    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

        switch(getItemViewType(i)){
            case 1 : TextView sectionHeaderText = ((SectionHeaderViewHolder) viewHolder).sectionHeader;
                     break;

            case 0:  TextView heading = ((MyViewHolder) viewHolder).heading;
                     TextView description = ((MyViewHolder) viewHolder).description;
                     heading.setText(dataSet.get(i).getHeading());
                     description.setText(dataSet.get(i).getDescription());
                     break;

            default: break;
        }



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
