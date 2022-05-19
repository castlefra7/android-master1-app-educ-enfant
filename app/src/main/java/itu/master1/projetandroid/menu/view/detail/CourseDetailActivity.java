package itu.master1.projetandroid.menu.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import itu.master1.projetandroid.R;

public class CourseDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CONTENT_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        /*FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction().replace(R.id.id_frag_course_detail, CourseDetailFragment.class, null)
                .commit();
         */
        CourseDetailFragment frag = (CourseDetailFragment) getSupportFragmentManager().findFragmentById(R.id.id_frag_course_detail);
        int contentId = (int)getIntent().getExtras().get(EXTRA_CONTENT_ID);
        frag.setContent(contentId);
    }

}