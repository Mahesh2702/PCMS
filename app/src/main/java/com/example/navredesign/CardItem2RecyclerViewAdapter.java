package com.example.navredesign;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardItem2RecyclerViewAdapter extends RecyclerView.Adapter<CardItem2RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<CardItem2> cardItem2List;

//    public RecyclerViewAdapter(Context context, List<Item> data) {
//        this.context = context;
//        this.data = data;
//    }

    public CardItem2RecyclerViewAdapter(Context context, List<CardItem2> data) {
        this.context = context;
        this.cardItem2List = data;
    }

    @NonNull
    @Override
    public CardItem2RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.fragment_item,parent,false);
        View cardView = LayoutInflater.from(context).inflate(R.layout.card_item2,parent,false);
        MyViewHolder vHolder = new MyViewHolder(cardView);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardItem2RecyclerViewAdapter.MyViewHolder holder, int position) {
//        holder.itemNo_text.setText(data.get(position).getItemNo());
//        holder.itemVal_text.setText(data.get(position).getItemValue());
        holder.tv_name.setText(cardItem2List.get(position).getName());
        holder.tv_earnedPercent.setText(String.valueOf(cardItem2List.get(position).getEarnedPercent()).concat("% / "));
        holder.tv_totalPercent.setText(String.valueOf(cardItem2List.get(position).getTotalPercent()).concat("%"));
        holder.tv_ratePercent.setText(String.valueOf(cardItem2List.get(position).getRate()));
        holder.tv_minServiceCnt.setText(String.valueOf(cardItem2List.get(position).getServices()).concat("/"));
        holder.tv_totalServiceCnt.setText(String.valueOf(cardItem2List.get(position).getTotalServices()));
        int rating = cardItem2List.get(position).getStarRating();
        if(rating == 5){
            holder.tv_name.setTextColor(Color.parseColor("#77bf6f"));
        }
        for (int i = 0; i < holder.tv_arrRating.length && i < rating; i++) {
            holder.tv_arrRating[i].setBackgroundColor(Color.parseColor("#FFCBCBD3"));
        }
    }

    @Override
    public int getItemCount() {
        return cardItem2List.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_earnedPercent;
        private TextView tv_totalPercent;
        private TextView tv_ratePercent;
        private TextView tv_minServiceCnt;
        private TextView tv_totalServiceCnt;
        private TextView tv_rating1;
        private TextView tv_rating2;
        private TextView tv_rating3;
        private TextView tv_rating4;
        private TextView tv_rating5;
        private TextView[] tv_arrRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.custom_id_text_card2);
            tv_earnedPercent = itemView.findViewById(R.id.minEarnedPercentTxt);
            tv_totalPercent = itemView.findViewById(R.id.maxEarnedPercentTotalTxt);
            tv_ratePercent = itemView.findViewById(R.id.ratePercentTotalTxt);
            tv_minServiceCnt = itemView.findViewById(R.id.minServicePercentTxt);
            tv_totalServiceCnt = itemView.findViewById(R.id.maxServicePercentTotalTxt);
            tv_rating1 = itemView.findViewById(R.id.rating1);
            tv_rating2 = itemView.findViewById(R.id.rating2);
            tv_rating3 = itemView.findViewById(R.id.rating3);
            tv_rating4 = itemView.findViewById(R.id.rating4);
            tv_rating5 = itemView.findViewById(R.id.rating5);
            tv_arrRating = new TextView[]{tv_rating1, tv_rating2, tv_rating3, tv_rating4, tv_rating5};
        }

    }
}
