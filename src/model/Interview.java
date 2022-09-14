package model;

import java.util.Objects;

public class Interview implements BroadcastSegment {
    private static final int PRICE = 30;
    private String guest;
    private int duration;

    public Interview(String guest, int length) {
        this.guest = guest;
        this.duration = length;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
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
        Interview interview = (Interview) o;
        return duration == interview.duration && Objects.equals(guest, interview.guest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guest, duration);
    }

    @Override
    public String toString() {
        return "Interview's guest: " + guest + ", length: " + duration + " seconds";
    }
}
