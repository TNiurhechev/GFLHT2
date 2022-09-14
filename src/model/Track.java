package model;

import java.util.Objects;

public class Track implements BroadcastSegment {
    private String name;
    private String artist;
    private int duration;

    public Track(String name, String artist, int length) {
        this.name = name;
        this.artist = artist;
        this.duration = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getProfit() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return duration == track.duration && Objects.equals(name, track.name) && Objects.equals(artist, track.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, artist, duration);
    }

    @Override
    public String toString() {
        return "Track's name: " + name + " is performed by " + artist + ", length: " + duration + "seconds";
    }
}
