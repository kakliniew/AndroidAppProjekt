package com.example.ramka.beacon;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ImageBeacon.class, name = "image"),
        @JsonSubTypes.Type(value = VideoBeacon.class, name = "video")
})
public class Beacon {
    private String id;
    private String text;
    private String soundPath;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSoundPath() {
        return soundPath;
    }

    public void setSoundPath(String soundPath) {
        this.soundPath = soundPath;
    }

    @Override
    public String toString() {
        return "Beacon{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", soundPath='" + soundPath + '\'' +
                '}';
    }
}
