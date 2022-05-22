package itu.master1.projetandroid.menu.view.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat$InspectionCompanion;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import java.io.InputStream;
import java.net.URL;
import java.util.Locale;

public class CourseDetailActivity extends YouTubeBaseActivity {
    // TODO: get API key from connexion
    String api_key = "AIzaSyBcHxvKqApJAm_MJ0CfVNtgkB88FVDOzjM";
    private Content content;
    LinearLayout imgContainer;



    public static final String EXTRA_CONTENT = "content";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Content content = (Content)getIntent().getExtras().get(EXTRA_CONTENT);
        setContent(content);
        //CourseDetailFragment frag = (CourseDetailFragment) getSupportFragmentManager().findFragmentById(R.id.id_frag_course_detail);
        //frag.setContent(content);

        imgContainer = (LinearLayout)findViewById(R.id.imgContainer);

        // Display video
        /*
        YouTubePlayerSupportFragmentX youTubePlayerFragment = YouTubePlayerSupportFragmentX.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.ytPlayer, youTubePlayerFragment).commit();
        */


        //YouTubePlayerSupportFragmentX youTubePlayerFragment = (YouTubePlayerSupportFragmentX) getChildFragmentManager().findFragmentById(R.id.ytPlayer);
        if(content.getVideo() != null && content.getVideo().isEmpty() == false) {
            YouTubePlayerView youTubePlayerFragment = (YouTubePlayerView)findViewById(R.id.ytPlayer);
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
                                YouTubePlayer youTubePlayer, boolean b) {
                            //youTubePlayer.loadVideo("HzeK7g8cD0Y");

                            youTubePlayer.loadVideo(content.getVideo());
                            youTubePlayer.play();


                        }

                        // Inside onInitializationFailure
                        // implement the failure functionality
                        // Here we will show toast
                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult
                                                                    youTubeInitializationResult) {
                            Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        //View view = getView();
        if(content != null) { //&& view != null

            TextView title = (TextView) findViewById(R.id.txtTitle);
            TextView desc = (TextView)findViewById(R.id.txtDescription);

            title.setText(content.getTitle().toUpperCase(Locale.ROOT));
            desc.setText(content.getDescription());
        }

        // Display Images
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,0,0,16);
        params.gravity = Gravity.CENTER;
        for(int iI = 0; iI < content.getImages().length; iI++) {
            ImageView img = new ImageView(CourseDetailActivity.this);
            img.setLayoutParams(params);
            img.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                }
            });
            imgContainer.addView(img);

            new DownLoadImageTask(img).execute(content.getImages()[iI]);

        }

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public void setContent(Content content) {
        this.content = content;
    }

    private class DownLoadImageTask extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }


        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                logo = BitmapFactory.decodeStream(is);

            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }

}