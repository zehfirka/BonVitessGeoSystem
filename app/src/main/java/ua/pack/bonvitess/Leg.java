package ua.pack.bonvitess;

public class Leg {
    private Time arrivalTime;
    private Time departureTime;
    private Distance distance;
    private Distance duration;
    private String endAddress;
    private Northeast endLocation;
    private String startAddress;
    private Northeast startLocation;
    private Step[] steps;
    private Object[] trafficSpeedEntry;
    private Object[] viaWaypoint;

    public Time getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(Time value) { this.arrivalTime = value; }

    public Time getDepartureTime() { return departureTime; }
    public void setDepartureTime(Time value) { this.departureTime = value; }

    public Distance getDistance() { return distance; }
    public void setDistance(Distance value) { this.distance = value; }

    public Distance getDuration() { return duration; }
    public void setDuration(Distance value) { this.duration = value; }

    public String getEndAddress() { return endAddress; }
    public void setEndAddress(String value) { this.endAddress = value; }

    public Northeast getEndLocation() { return endLocation; }
    public void setEndLocation(Northeast value) { this.endLocation = value; }

    public String getStartAddress() { return startAddress; }
    public void setStartAddress(String value) { this.startAddress = value; }

    public Northeast getStartLocation() { return startLocation; }
    public void setStartLocation(Northeast value) { this.startLocation = value; }

    public Step[] getSteps() { return steps; }
    public void setSteps(Step[] value) { this.steps = value; }

    public Object[] getTrafficSpeedEntry() { return trafficSpeedEntry; }
    public void setTrafficSpeedEntry(Object[] value) { this.trafficSpeedEntry = value; }

    public Object[] getViaWaypoint() { return viaWaypoint; }
    public void setViaWaypoint(Object[] value) { this.viaWaypoint = value; }
}
