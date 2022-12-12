package ua.pack.bonvitess;

public class TransitDetails {
    private Stop arrivalStop;
    private Time arrivalTime;
    private Stop departureStop;
    private Time departureTime;
    private String headsign;
    private long headway;
    private Line line;
    private long numStops;

    public Stop getArrivalStop() { return arrivalStop; }
    public void setArrivalStop(Stop value) { this.arrivalStop = value; }

    public Time getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(Time value) { this.arrivalTime = value; }

    public Stop getDepartureStop() { return departureStop; }
    public void setDepartureStop(Stop value) { this.departureStop = value; }

    public Time getDepartureTime() { return departureTime; }
    public void setDepartureTime(Time value) { this.departureTime = value; }

    public String getHeadsign() { return headsign; }
    public void setHeadsign(String value) { this.headsign = value; }

    public long getHeadway() { return headway; }
    public void setHeadway(long value) { this.headway = value; }

    public Line getLine() { return line; }
    public void setLine(Line value) { this.line = value; }

    public long getNumStops() { return numStops; }
    public void setNumStops(long value) { this.numStops = value; }
}
