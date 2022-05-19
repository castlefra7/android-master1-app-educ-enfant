package itu.master1.projetandroid.menu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.view.detail.CourseDetailActivity;
import itu.master1.projetandroid.menu.view.list.CoursesFragment;
import itu.master1.projetandroid.menu.view.settings.SettingsFragment;

public class MenuActivity extends AppCompatActivity implements Listener {



    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_menu);

        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction().replace(R.id.id_frag_menu_container, CoursesFragment.class, null).commit();

        configureBottomView();
        configureCards();
    }

    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(CourseDetailActivity.EXTRA_CONTENT_ID, (int)id);
        startActivity(intent);
    }

    public void onShowDetails(View view) {
        Intent intent = new Intent(this, CourseDetailActivity.class);
        startActivity(intent);
    }

    private void configureBottomView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (id) {
                case R.id.action_menu:
                    ft.replace(R.id.id_frag_menu_container, CoursesFragment.class, null);
                    break;
                case R.id.action_settings:
                    ft.replace(R.id.id_frag_menu_container, SettingsFragment.class, null);
                default:
                    break;
            }

            ft.commit();
            return true;
        });
    }

    private void configureCards() {
        /*CardView cardView = findViewById(R.id.firstCard);
        System.out.println(cardView);
        if(cardView != null) {

        cardView.setOnClickListener(event -> {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new CourseFragment());
            ft.commit();
        });
        }

         */

    }

}
