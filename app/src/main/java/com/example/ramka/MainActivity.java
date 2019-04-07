package com.example.ramka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.ramka.beacon.Beacon;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        LinearLayout buttonsLayout = findViewById(R.id.buttonLayout);

        BeaconManager manager = new BeaconManager();

        List<Beacon> beacons = manager.loadBeacons(this);
        for (Beacon beacon : beacons) {
            Button button = new BeaconButton(this, beacon);
            button.setText(beacon.getId());

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            buttonsLayout.addView(button, lp);
        }
    }
}
