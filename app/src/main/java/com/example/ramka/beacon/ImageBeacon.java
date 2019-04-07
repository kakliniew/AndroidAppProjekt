package com.example.ramka.beacon;

public class ImageBeacon extends Beacon {
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return super.toString() + ", ImageBeacon{" +
                "imagePath='" + imagePath + '\'' +
                '}';
    }
}
