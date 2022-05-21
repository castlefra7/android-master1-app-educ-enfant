package itu.master1.projetandroid.menu.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;


import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;


public class CourseDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CONTENT = "content";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Content content = (Content)getIntent().getExtras().get(EXTRA_CONTENT);
        CourseDetailFragment frag = (CourseDetailFragment) getSupportFragmentManager().findFragmentById(R.id.id_frag_course_detail);
        frag.setContent(content);
    }

}