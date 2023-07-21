package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.storage.StorageReference;

public class daily_frustation extends AppCompatActivity {
    VideoView vv;
    MediaController mc;
    Uri videouri;
    StorageReference mstoraferef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_frustation);
        vv=findViewById(R.id.vv3);
        videouri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/mittihub-f4660.appspot.com/o/videos%2Fdaily_frustation.mp4?alt=media&token=7a2a1121-ee3b-4405-a0c3-3964092dc219");
        vv.setVideoURI(videouri);
        vv.requestFocus();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc=new MediaController(daily_frustation.this);
                        vv.setMediaController(mc);
                        mc.setAnchorView(vv);
                    }

                });

            }
        });
        vv.start();

    }
}