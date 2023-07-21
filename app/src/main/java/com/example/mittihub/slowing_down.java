package com.example.mittihub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.firebase.storage.StorageReference;

public class slowing_down extends AppCompatActivity {
    VideoView vv;
    MediaController mc;
    Uri videouri;
    StorageReference mstoraferef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slowing_down);
        vv=findViewById(R.id.vv4);
        videouri=Uri.parse("https://firebasestorage.googleapis.com/v0/b/mittihub-f4660.appspot.com/o/videos%2Fslowing_down.mp4?alt=media&token=fe0429d2-089a-4cbb-9433-0f7347ce3a90");
        vv.setVideoURI(videouri);
        vv.requestFocus();

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc=new MediaController(slowing_down.this);
                        vv.setMediaController(mc);
                        mc.setAnchorView(vv);
                    }

                });

            }
        });
        vv.start();

    }
}