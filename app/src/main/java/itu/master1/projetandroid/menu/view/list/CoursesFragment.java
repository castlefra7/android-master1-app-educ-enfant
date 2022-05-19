package itu.master1.projetandroid.menu.view.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;
import itu.master1.projetandroid.menu.view.Listener;

public class CoursesFragment extends ListFragment {
    private Listener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_courses, parent, false);
        String[] titles = new String[Content.contents.length];
        for(int i = 0; i < titles.length; i++) titles[i] = Content.contents[i].getTitle();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, titles
        );
        setListAdapter(adapter);
        return super.onCreateView(inflater, parent, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if(listener != null) {
            listener.itemClicked(id);
        }
    }

}
