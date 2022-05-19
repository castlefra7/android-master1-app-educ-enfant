package itu.master1.projetandroid.menu.view.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;
import itu.master1.projetandroid.menu.view.detail.CourseDetailActivity;

public class CoursesFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        ConstraintLayout mainLayout = (ConstraintLayout) inflater.inflate(R.layout.fragment_courses, parent, false);
        LinearLayout mainLayoutLinear = mainLayout.findViewById(R.id.id_linear_for_recycle);

        RecyclerView courseRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_course_list, mainLayoutLinear, false);
        String[] titles = new String[Content.contents.length];
        String[] descriptions = new String[Content.contents.length];
        for(int i = 0; i < titles.length; i++) {
            titles[i] = Content.contents[i].getTitle();
            descriptions[i] = Content.contents[i].getDescription();
        }

        ContentAdapter adapter =    new ContentAdapter(titles, descriptions);
        courseRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        courseRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new ContentAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), CourseDetailActivity.class);
                intent.putExtra(CourseDetailActivity.EXTRA_CONTENT_ID, position);
                getActivity().startActivity(intent);
            }
        });

        mainLayoutLinear.addView(courseRecycler);
        return mainLayout;
    }

}
