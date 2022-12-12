package ua.pack.bonvitess;

import java.util.List;

public class Route {
    private Bounds bounds;
    private String copyrights;
    private Fare fare;
    private Leg[] legs;
    private Polyline overviewPolyline;
    private String summary;
    private String[] warnings;
    private Object[] waypointOrder;

    private List<Root> rootList;

    public Bounds getBounds() { return bounds; }
    public void setBounds(Bounds value) { this.bounds = value; }

    public String getCopyrights() { return copyrights; }
    public void setCopyrights(String value) { this.copyrights = value; }

    public Fare getFare() { return fare; }
    public void setFare(Fare value) { this.fare = value; }

    public Leg[] getLegs() { return legs; }
    public void setLegs(Leg[] value) { this.legs = value; }

    public Polyline getOverviewPolyline() { return overviewPolyline; }
    public void setOverviewPolyline(Polyline value) { this.overviewPolyline = value; }

    public String getSummary() { return summary; }
    public void setSummary(String value) { this.summary = value; }

    public String[] getWarnings() { return warnings; }
    public void setWarnings(String[] value) { this.warnings = value; }

    public Object[] getWaypointOrder() { return waypointOrder; }
    public void setWaypointOrder(Object[] value) { this.waypointOrder = value; }
}
