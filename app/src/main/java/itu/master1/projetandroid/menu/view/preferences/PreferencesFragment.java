package itu.master1.projetandroid.menu.view.preferences;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import java.util.ArrayList;
import java.util.List;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.authentication.view.ConnexionActivity;
import itu.master1.projetandroid.menu.model.Content;
import itu.master1.projetandroid.menu.view.DelayedMessageService;
import itu.master1.projetandroid.menu.view.MenuActivity;
import itu.master1.projetandroid.menu.view.detail.CourseDetailActivity;
import itu.master1.projetandroid.menu.view.list.ContentAdapter;
import itu.master1.projetandroid.menu.viewmodel.CoursesViewModel;
import kotlinx.coroutines.Delay;

public class PreferencesFragment extends PreferenceFragmentCompat {
    private CoursesViewModel coursesViewModel;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        coursesViewModel = new ViewModelProvider(this.getActivity()).get(CoursesViewModel.class);

        // Notification preference
        SwitchPreferenceCompat prefNofit = findPreference("notifications");
        prefNofit.setChecked(false);
        Intent intent = new Intent(getActivity(), DelayedMessageService.class);
        coursesViewModel.getContentsLive().observe(this, new Observer<List<Content>>() {
            @Override
            public void onChanged(List<Content> contents) {
                if(contents != null && contents.size() > 0) {
                    intent.putParcelableArrayListExtra(DelayedMessageService.EXTRA_CONTENT, (ArrayList<? extends Parcelable>) contents);
                }
            }
        });
        prefNofit.setOnPreferenceChangeListener((preference, newValue) -> {
            if((Boolean)newValue == true) {
                getActivity().startService(intent);
            } else {
                getActivity().stopService(intent);
            }
            return true;
        });


        // Frequency Preference
        ListPreference listPreference = findPreference("freq_list");
        String[] entries = new String[]{"5 sec", "10 sec", "30 sec", "1 mn"};
        listPreference.setEntries(entries);
        listPreference.setEntryValues(entries);
        if(listPreference.getValue() == null) {
            listPreference.setValueIndex(0);
        }

        listPreference.setOnPreferenceChangeListener((preference, newValue) -> {
            System.out.println(newValue);
            if ("10 sec".equals(newValue)) {
                intent.putExtra(DelayedMessageService.EXTRA_FREQUENCY, 10000);
            } else if ("30 sec".equals(newValue)) {
                intent.putExtra(DelayedMessageService.EXTRA_FREQUENCY, 30000);
            } else if ("1 mn".equals(newValue)) {
                intent.putExtra(DelayedMessageService.EXTRA_FREQUENCY, 60000);
            } else {
                intent.putExtra(DelayedMessageService.EXTRA_FREQUENCY, 5000);
            }

            return true;
        });

    }


}
