package itu.master1.projetandroid.menu.view.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;

import java.util.Locale;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;


public class CourseDetailFragment extends Fragment {

    private Content content;
    String api_key = "AIzaSyBcHxvKqApJAm_MJ0CfVNtgkB88FVDOzjM";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_course_detail, parent, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view =  getView();

        if(view != null && content != null) {

            System.out.println(content.getTitle());
            TextView title = (TextView) view.findViewById(R.id.txtTitle);
            TextView desc = (TextView)view.findViewById(R.id.txtDescription);

            title.setText(content.getTitle().toUpperCase(Locale.ROOT));
            desc.setText(content.getDescription());
        }


        YouTubePlayerSupportFragmentX youTubePlayerFragment = YouTubePlayerSupportFragmentX.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.ytPlayer, youTubePlayerFragment).commit();

        //YouTubePlayerSupportFragmentX youTubePlayerFragment = (YouTubePlayerSupportFragmentX) getChildFragmentManager().findFragmentById(R.id.ytPlayer);
        youTubePlayerFragment.initialize(
                api_key,
                new YouTubePlayer.OnInitializedListener() {
                    // Implement two methods by clicking on red
                    // error bulb inside onInitializationSuccess
                    // method add the video link or the playlist
                    // link that you want to play In here we
                    // also handle the play and pause
                    // functionality
                    @Override
                    public void onInitializationSuccess(
                            YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b)
                    {
                        youTubePlayer.loadVideo("HzeK7g8cD0Y");
                        youTubePlayer.play();
                    }

                    // Inside onInitializationFailure
                    // implement the failure functionality
                    // Here we will show toast
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult
                                                                youTubeInitializationResult)
                    {
                        Toast.makeText(getActivity().getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                    }
                });


    }

    public void setContent(Content content) {
        this.content = content;
    }
}
