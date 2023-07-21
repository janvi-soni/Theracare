package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.storage.StorageReference;

public class work_life_balance extends AppCompatActivity {
    VideoView vv;
    MediaController mc;
    Uri videouri;
    StorageReference mstoraferef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_life_balance);
        vv=findViewById(R.id.vv1);
        videouri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/mittihub-f4660.appspot.com/o/videos%2Fwork_life_balance.mp4?alt=media&token=48848333-1a79-48f8-b342-d6c62bebb2a1");
        vv.setVideoURI(videouri);
        vv.requestFocus();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc=new MediaController(work_life_balance.this);
                        vv.setMediaController(mc);
                        mc.setAnchorView(vv);
                    }

                });

            }
        });
        vv.start();

    }
}