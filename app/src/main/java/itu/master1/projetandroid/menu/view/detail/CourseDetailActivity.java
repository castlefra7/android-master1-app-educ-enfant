package itu.master1.projetandroid.menu.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;

import itu.master1.projetandroid.R;
import itu.master1.projetandroid.menu.model.Content;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;
import com.google.android.youtube.player.YouTubePlayerView;

public class CourseDetailActivity extends YouTubeBaseActivity {
    String api_key = "AIzaSyBcHxvKqApJAm_MJ0CfVNtgkB88FVDOzjM";

    public static final String EXTRA_CONTENT = "content";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Content content = (Content)getIntent().getExtras().get(EXTRA_CONTENT);
        //CourseDetailFragment frag = (CourseDetailFragment) getSupportFragmentManager().findFragmentById(R.id.id_frag_course_detail);
        //frag.setContent(content);


       /* YouTubePlayerSupportFragmentX youTubePlayerFragment = YouTubePlayerSupportFragmentX.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.ytPlayer, youTubePlayerFragment).commit();
*/
        YouTubePlayerView youTubePlayerFragment = (YouTubePlayerView)findViewById(R.id.ytPlayer);

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
                        Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}