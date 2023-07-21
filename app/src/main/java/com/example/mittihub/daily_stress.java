package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.storage.StorageReference;

public class daily_stress extends AppCompatActivity {
    VideoView vv;
    MediaController mc;
    Uri videouri;
    StorageReference mstoraferef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_stress);
        vv=findViewById(R.id.vv2);
        videouri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/mittihub-f4660.appspot.com/o/videos%2Fdaly_stress.mp4?alt=media&token=f311ec72-949d-48ee-8ace-5ae0b4fb7d5a");
        vv.setVideoURI(videouri);
        vv.requestFocus();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc=new MediaController(daily_stress.this);
                        vv.setMediaController(mc);
                        mc.setAnchorView(vv);
                    }

                });

            }
        });
        vv.start();

    }
}