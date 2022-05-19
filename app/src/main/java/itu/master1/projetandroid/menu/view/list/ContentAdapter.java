package itu.master1.projetandroid.menu.view.list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import itu.master1.projetandroid.R;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private String[] titles;
    private String[] descriptions;
    private Listener listener;
    interface Listener {
        void onClick(int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_content, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CardView cardView = holder.cardView;
        TextView txtTitle = (TextView)cardView.findViewById(R.id.id_card_title);
        TextView txtDescrpition = (TextView)cardView.findViewById(R.id.id_card_description);

        txtTitle.setText(titles[position]);
        txtDescrpition.setText(descriptions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) listener.onClick(position);
            }
        });
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return this.titles.length;
    }

    public ContentAdapter(String[] titles, String[] descriptions) {
        this.titles = titles;
        this.descriptions = descriptions;
    }
}
