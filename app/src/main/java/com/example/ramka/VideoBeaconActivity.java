package com.example.ramka;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.ramka.beacon.Beacon;
import com.example.ramka.beacon.ImageBeacon;
import com.example.ramka.beacon.VideoBeacon;

public class VideoBeaconActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.beacon_video);

        String beaconId;
        if (savedInstanceState == null) {
            beaconId = this.getIntent().getStringExtra("beacon");
        } else {
            beaconId = savedInstanceState.getString("beacon");
        }

        if (beaconId == null)
        {
            this.finishAffinity();
        }

        BeaconManager manager = new BeaconManager();

        Beacon beacon = null;
        for (Beacon loadBeacon : manager.loadBeacons(this)) {
            if (loadBeacon.getId().equals(beaconId))
            {
                beacon = loadBeacon;
                break;
            }
        }

        if (!(beacon instanceof VideoBeacon))
        {
            this.finishAffinity();
            return;
        }
        if (beacon.getSoundPath() != null) {
            MediaPlayer player = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName() + "/" + beacon.getSoundPath()));
            player.start();
        }

        if (((VideoBeacon) beacon).getVideoPath() != null) {
            MediaController controller = new MediaController(this);
            VideoView video = this.findViewById(R.id.beacon_video);
            video.setMediaController(controller);
            video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + ((VideoBeacon) beacon).getVideoPath()));
            video.start();
        }

        if (beacon.getText() != null) {
            TextView beaconText = this.findViewById(R.id.beacon_text);
            beaconText.setText(beacon.getText());
        }
    }
}
