package com.example.surejahit.mytripbooking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class MyRecyclerViewAdapter extends RecyclerView
        .Adapter<MyRecyclerViewAdapter
        .DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<DataObject> mDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView label;
        TextView dateTime;
        ImageView img;
        Context context;

        public DataObjectHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            label = (TextView) itemView.findViewById(R.id.textView);
            dateTime = (TextView) itemView.findViewById(R.id.textView2);
            img = (ImageView)itemView.findViewById(R.id.imgView);
            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            myClickListener.onItemClick(getAdapterPosition(), v);


            final Intent intent;
            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(context,Location1Activity.class);
                    break;

                case 1:
                    intent =  new Intent(context, Location2Activity.class);
                    break;
                case 2:
                    intent =  new Intent(context, Location3Activity.class);
                    break;
                case 3:
                    intent =  new Intent(context, Location4Activity.class);
                    break;
                case 4:
                    intent =  new Intent(context, Location5Activity.class);
                    break;
                case 5:
                    intent =  new Intent(context, Location6Activity.class);
                    break;
                    default:
                        intent =  new Intent(context, Location1Activity.class);
                        break;

            }
            context.startActivity(intent);

        }


    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;

    }

    public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }


    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.label.setText(mDataset.get(position).getmText1());
        holder.dateTime.setText(mDataset.get(position).getmText2());
        holder.img.setImageResource(mDataset.get(position).getimg());

    }



    public void addItem(DataObject dataObj, int index) {
        mDataset.add(index, dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}