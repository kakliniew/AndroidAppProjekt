package com.example.ramka.beacon;

public class VideoBeacon extends Beacon {
    private String videoPath;

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return super.toString() + ", VideoBeacon{" +
                "videoPath='" + videoPath + '\'' +
                '}';
    }
}
