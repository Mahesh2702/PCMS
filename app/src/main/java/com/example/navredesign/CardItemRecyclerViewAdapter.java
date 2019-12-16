package com.example.navredesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardItemRecyclerViewAdapter extends RecyclerView.Adapter<CardItemRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Item> data;
    List<CardItem> cardItems;

//    public RecyclerViewAdapter(Context context, List<Item> data) {
//        this.context = context;
//        this.data = data;
//    }

    public CardItemRecyclerViewAdapter(Context context, List<CardItem> data) {
        this.context = context;
        this.cardItems = data;
    }

    @NonNull
    @Override
    public CardItemRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.fragment_item,parent,false);
        View cardView = LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false);
        MyViewHolder vHolder = new MyViewHolder(cardView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemRecyclerViewAdapter.MyViewHolder holder, int position) {
//        holder.itemNo_text.setText(data.get(position).getItemNo());
//        holder.itemVal_text.setText(data.get(position).getItemValue());
        holder.tv_name.setText(cardItems.get(position).getName());
        holder.tv_earnedPercent.setText(String.valueOf(cardItems.get(position).getEarnedPercent()).concat("% / ") );
        holder.tv_totalPercent.setText(String.valueOf(cardItems.get(position).getTotalPercent()).concat("%"));
        holder.pb_bar.setProgress(cardItems.get(position).getProgress());
//        PieProgressDrawable pieProgressDrawable = new PieProgressDrawable();
//        pieProgressDrawable.setColor( R.color.white);
//        holder.timeProgress.setImageDrawable(pieProgressDrawable);
//        pieProgressDrawable.setLevel(cardItems.get(position).getProgress());
//        holder.timeProgress.invalidate();
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_earnedPercent;
        private TextView tv_totalPercent;
        private ImageView timeProgress;
        private ProgressBar pb_bar;
//        ImageView pb_bar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.custom_id_text);
            tv_earnedPercent = itemView.findViewById(R.id.earnedPercentTxt);
            tv_totalPercent = itemView.findViewById(R.id.earnedPercentTotalTxt);

//             timeProgress = (ImageView) itemView.findViewById(R.id.time_progress);

            pb_bar = itemView.findViewById(R.id.progress_horizontal);
//            ProgressBar pb = (ProgressBar) itemView.findViewById(R.id.progress_horizontal);
//
//            Animation an = new RotateAnimation(0.0f, 90.0f, 250f, 273f);
//            an.setFillAfter(true);
//            pb.startAnimation(an);
        }
//        private TextView itemNo_text;
//        private TextView itemVal_text;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            itemNo_text = itemView.findViewById(R.id.item_number);
//            itemVal_text = itemView.findViewById(R.id.item_content);
//        }

    }
}
