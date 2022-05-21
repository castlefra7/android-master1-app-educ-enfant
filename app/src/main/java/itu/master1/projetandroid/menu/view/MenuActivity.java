package itu.master1.projetandroid.menu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.view.list.CoursesFragment;
import itu.master1.projetandroid.menu.view.preferences.PreferencesFragment;
import kotlinx.coroutines.Delay;

public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_menu);

        FragmentManager ft = getSupportFragmentManager();
        ft.beginTransaction().replace(R.id.id_frag_menu_container, CoursesFragment.class, null).commit();

        configureBottomView();
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
                    ft.replace(R.id.id_frag_menu_container, PreferencesFragment.class, null);
                default:
                    break;
            }

            ft.commit();
            return true;
        });
    }
    public void onClick(View view) {
        Intent intent = new Intent(this, DelayedMessageService.class);
        intent.putExtra(DelayedMessageService.EXTRA_MESSAGE, "Ndana amzay mianatra e");
        startService(intent);
    }
}
