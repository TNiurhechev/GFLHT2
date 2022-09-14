package model;

import model.BroadcastSegment;

import java.util.ArrayList;
import java.util.List;

public class Broadcast {
    private List<BroadcastSegment> segments;
    private int maxDuration;

    public Broadcast(int maxDuration) {
        this.maxDuration = maxDuration;
        this.segments = new ArrayList<>();
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public void addSegment(BroadcastSegment segment){
        if(getOverallDuration()+segment.getDuration()>maxDuration){
            System.out.println("Segment too long!");
            return;
        }
        else if(segment instanceof Interview || segment instanceof Ad){
            if(getPaidSegmentsDuration()+segment.getDuration()>getOverallDuration()/2)
                System.out.println("Too much monetized content!");
        }
        else
            segments.add(segment);
    }

    public List<BroadcastSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<BroadcastSegment> segments) {
        this.segments = segments;
    }

    public int getOverallDuration(){
        int overallDuration = 0;
        for(var segment: segments)
            overallDuration += segment.getDuration();
        return overallDuration;
    }

    public int getPaidSegmentsDuration(){
        int paidSegmentsDuration = 0;
        for(var segment: segments)
            if(segment instanceof Interview || segment instanceof Ad)
                paidSegmentsDuration += segment.getDuration();
        return paidSegmentsDuration;
    }

    public int getSegmentProfit(BroadcastSegment segment){
        if(segments.contains(segment))
            return segment.getProfit();
        else
            return 0;
    }

    public void printSegments(){
        for(var segment:segments)
            System.out.println(segment.toString());
    }

    @Override
    public String toString() {
        return "Broadcast consists of" + segments.size() + " parts, broadcast's length: " + getOverallDuration() + "seconds";
    }
}
