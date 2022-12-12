package ua.pack.bonvitess;

public class GeocodedWaypoint {
    private String geocoderStatus;
    private String placeID;
    private String[] types;

    public String getGeocoderStatus() { return geocoderStatus; }
    public void setGeocoderStatus(String value) { this.geocoderStatus = value; }

    public String getPlaceID() { return placeID; }
    public void setPlaceID(String value) { this.placeID = value; }

    public String[] getTypes() { return types; }
    public void setTypes(String[] value) { this.types = value; }
}
