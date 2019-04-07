package com.example.ramka;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.example.ramka.beacon.Beacon;
import com.example.ramka.beacon.ImageBeacon;
import com.example.ramka.beacon.VideoBeacon;

public class BeaconButton extends AppCompatButton {
    private final Beacon beacon;

    public BeaconButton(Context context, final Beacon beacon) {
        super(context);
        this.beacon = beacon;

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(BeaconButton.this.beacon);
                Class beaconActivityClass;
                if (BeaconButton.this.beacon instanceof ImageBeacon)
                {
                    beaconActivityClass = ImageBeaconActivity.class;
                }
                else if (BeaconButton.this.beacon instanceof VideoBeacon)
                {
                    beaconActivityClass = VideoBeaconActivity.class;
                }
                else
                {
                    return;
                }

                Intent intent = new Intent(view.getContext(), beaconActivityClass);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("beacon", BeaconButton.this.beacon.getId());
                view.getContext().startActivity(intent);
            }
        });
    }
}
