package itu.master1.projetandroid.menu.view;

import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import itu.master1.projetandroid.R;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_menu);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new CoursesFragment());
        ft.commit();

        configureBottomView();
        configureCards();
    }

    private void configureBottomView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (id) {
                case R.id.action_menu:
                    ft.replace(R.id.fragment_container, new CoursesFragment());
                    break;
                case R.id.action_settings:
                    ft.replace(R.id.fragment_container, new SettingsFragment());
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
