package model;

import java.util.List;
import java.util.Objects;

//Builder pattern
public class Host {
    private String name;
    private String cv;
    private int experience;
    private List<BroadcastSegment>  hostedSegments;

    private Host(){}

    public static class HostBuilder {
        private String name;
        private String cv;
        private int experience;
        private List<BroadcastSegment>  hostedSegments;

        public HostBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HostBuilder setCv(String cv) {
            this.cv = cv;
            return this;
        }

        public HostBuilder setExperience(int experience) {
            this.experience = experience;
            return this;
        }

        public HostBuilder setHostedSegments(List<BroadcastSegment> hostedSegments) {
            this.hostedSegments = hostedSegments;
            return this;
        }

        public Host build(){
            Host host = new Host();
            host.name = name;
            host.cv = cv;
            host.experience = experience;
            host.hostedSegments = hostedSegments;
            if(cv == null && experience == 0)
                return null;
            return host;
        }
    }

    @Override
    public String toString() {
        return "Host's name: " + name +", CV: " + cv + ", has " + experience +
                " years of experience, hosts " + hostedSegments.size() + " segments";
    }
}
