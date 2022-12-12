package ua.pack.bonvitess;

public class Step {
    private Distance distance;
    private Distance duration;
    private Northeast endLocation;
    private String htmlInstructions;
    private Polyline polyline;
    private Northeast startLocation;
    private Step[] steps;
    private String travelMode;
    private TransitDetails transitDetails;
    private String maneuver;

    public Distance getDistance() { return distance; }
    public void setDistance(Distance value) { this.distance = value; }

    public Distance getDuration() { return duration; }
    public void setDuration(Distance value) { this.duration = value; }

    public Northeast getEndLocation() { return endLocation; }
    public void setEndLocation(Northeast value) { this.endLocation = value; }

    public String getHTMLInstructions() { return htmlInstructions; }
    public void setHTMLInstructions(String value) { this.htmlInstructions = value; }

    public Polyline getPolyline() { return polyline; }
    public void setPolyline(Polyline value) { this.polyline = value; }

    public Northeast getStartLocation() { return startLocation; }
    public void setStartLocation(Northeast value) { this.startLocation = value; }

    public Step[] getSteps() { return steps; }
    public void setSteps(Step[] value) { this.steps = value; }

    public String getTravelMode() { return travelMode; }
    public void setTravelMode(String value) { this.travelMode = value; }

    public TransitDetails getTransitDetails() { return transitDetails; }
    public void setTransitDetails(TransitDetails value) { this.transitDetails = value; }

    public String getManeuver() { return maneuver; }
    public void setManeuver(String value) { this.maneuver = value; }
}
