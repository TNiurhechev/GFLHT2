import model.*;

public class Main {
    public static void main(String[] args) {
        Broadcast broadcast = new Broadcast(3600);
        broadcast.addSegment(new Track("Heart Attack","Scarlxrd", 300));
        broadcast.addSegment(new Ad("Kyivstar",40));
        broadcast.addSegment(new Interview("Yuriy Hudymenko", 1800));
        broadcast.addSegment(new Ad("Danone", 45));
        System.out.println(broadcast.toString());
        broadcast.printSegments();

        broadcast.addSegment(new Ad("Duration overflow",2000));

        Host host = new Host.HostBuilder().setName("Roe Jogan").setCv("Invited host, 54 y.o.")
                .setHostedSegments(broadcast.getSegments()).build();
        System.out.println(host.toString());
    }
}
