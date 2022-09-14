package model;

import java.util.Objects;

public class Ad implements BroadcastSegment {
    private static final int PRICE = 5;
    private String name;
    private int duration;

    public Ad(String name, int length) {
        this.name = name;
        this.duration = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getProfit() {
        return PRICE*getDuration();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return duration == ad.duration && Objects.equals(name, ad.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public String toString() {
        return "Ad's name: " + name +", length: " + duration + "seconds";
    }
}
