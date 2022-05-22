package itu.master1.projetandroid.menu.view.preferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.authentication.view.ConnexionActivity;
import itu.master1.projetandroid.menu.view.MenuActivity;

public class PreferencesFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);


        // TODO: implement disable notifications
        Preference prefLogout = findPreference("notifications");
        prefLogout.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(@NonNull Preference preference) {

                return false;
            }
        });
    }
}
