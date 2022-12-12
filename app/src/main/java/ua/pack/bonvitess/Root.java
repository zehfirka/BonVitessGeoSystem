package ua.pack.bonvitess;

public class Root { //по логіці це "парсинг" файлу
    private GeocodedWaypoint[] geocodedWaypoints;
    private Route[] routes;
    private String status;

    public GeocodedWaypoint[] getGeocodedWaypoints() { return geocodedWaypoints; }
    public void setGeocodedWaypoints(GeocodedWaypoint[] value) { this.geocodedWaypoints = value; }

    public Route[] getRoutes() { return routes; }
    public void setRoutes(Route[] value) { this.routes = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }
}
