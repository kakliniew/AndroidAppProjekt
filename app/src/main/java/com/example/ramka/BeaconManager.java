package com.example.ramka;

import android.content.Context;

import com.example.ramka.beacon.Beacon;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BeaconManager
{
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Beacon> loadBeacons(Context context)
    {
        int beaconsResource = context.getResources().getIdentifier("beacons", "raw", context.getPackageName());
        try (InputStream inputStream = context.getApplicationContext().getResources().openRawResource(beaconsResource)) {
            CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Beacon.class);
            return objectMapper.readValue(inputStream, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
