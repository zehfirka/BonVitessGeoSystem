package ua.pack.bonvitess;

public class Line {
    private Agency[] agencies;
    private String color;
    private String name;
    private String shortName;
    private String textColor;
    private String url;
    private Vehicle vehicle;

    public Agency[] getAgencies() { return agencies; }
    public void setAgencies(Agency[] value) { this.agencies = value; }

    public String getColor() { return color; }
    public void setColor(String value) { this.color = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getShortName() { return shortName; }
    public void setShortName(String value) { this.shortName = value; }

    public String getTextColor() { return textColor; }
    public void setTextColor(String value) { this.textColor = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle value) { this.vehicle = value; }
}
