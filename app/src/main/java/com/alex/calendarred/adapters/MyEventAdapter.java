package com.alex.calendarred.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alex.calendarred.R;
import com.alex.calendarred.helper.ItemRandomColor;
import com.alex.calendarred.model.Orders;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.List;

public class MyEventAdapter extends RecyclerView.Adapter<MyEventAdapter.MyViewHolder> {

    private List<Orders> orders = new ArrayList<>();
    private Context context;

    public MyEventAdapter(List<Orders> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_event, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.timeText.setText(orders.get(position).getTime());
        holder.procedureText.setText(orders.get(position).getProcedure());
        holder.clientNameText.setText(orders.get(position).getNameclient());

        holder.cardView.setCardBackgroundColor(new  ItemRandomColor(context).generateRandomColor());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView timeText;
        private TextView procedureText;
        private TextView clientNameText;
        private CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            timeText = (TextView)itemView.findViewById(R.id.time_text);
            procedureText = (TextView)itemView.findViewById(R.id.procedure_text);
            clientNameText = (TextView)itemView.findViewById(R.id.client_name_text);
            cardView = (CardView)itemView.findViewById(R.id.card_view);

        }
    }
}
