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

import java.util.List;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {
    private List<Content> contentList;
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
        TextView txtDescription = (TextView)cardView.findViewById(R.id.id_card_description);

        txtTitle.setText(contentList.get(position).getTitle());
        txtDescription.setText(contentList.get(position).getDescription());

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
        return contentList.size();
    }

    public void setContentList(List<Content> contents) {
        this.contentList = contents;
    }

    public List<Content> getContentList() {
        return this.contentList;
    }

    public ContentAdapter(List<Content> _content) {
        this.contentList = _content;
    }
}
