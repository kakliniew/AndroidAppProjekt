package com.example.ramka;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.ramka.beacon.Beacon;
import com.example.ramka.beacon.ImageBeacon;
import com.example.ramka.beacon.VideoBeacon;

import java.net.URI;

public class ImageBeaconActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.beacon_image);

        String beaconId;
        if (savedInstanceState == null) {
            beaconId = this.getIntent().getStringExtra("beacon");
        } else {
            beaconId = savedInstanceState.getString("beacon");
        }

        if (beaconId == null) {
            this.finishAffinity();
        }

        BeaconManager manager = new BeaconManager();

        Beacon beacon = null;
        for (Beacon loadBeacon : manager.loadBeacons(this)) {
            if (loadBeacon.getId().equals(beaconId)) {
                beacon = loadBeacon;
                break;
            }
        }

        if (!(beacon instanceof ImageBeacon)) {
            this.finishAffinity();
            return;
        }
        if (beacon.getSoundPath() != null) {
            MediaPlayer player = MediaPlayer.create(this, Uri.parse("android.resource://" + getPackageName() + "/" + beacon.getSoundPath()));
            player.start();
        }

        if (((ImageBeacon) beacon).getImagePath() != null)
        {
            ImageView beaconImage = this.findViewById(R.id.beacon_image);
            beaconImage.setImageResource(this.getResources().getIdentifier(((ImageBeacon) beacon).getImagePath(), "raw", this.getPackageName()));
        }

        if (beacon.getText() != null) {
            TextView beaconText = this.findViewById(R.id.beacon_text);
            beaconText.setText(beacon.getText());
        }
    }

}
