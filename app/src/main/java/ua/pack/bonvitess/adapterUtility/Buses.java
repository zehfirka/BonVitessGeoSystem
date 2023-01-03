package ua.pack.bonvitess.adapterUtility;

public class Buses {
    //оголошення змінних
    private String number;
    private String destinationRoute;
    private String fee;
    private String distance;
    private String interval;

    //конструктор
    public Buses(String number, String destinationRoute, String fee, String distance, String interval) {
        this.number = number;
        this.destinationRoute = destinationRoute;
        this.fee = fee;
        this.distance = distance;
        this.interval = interval;
    }

    //набір гетерів

    public String getNumber() {
        return number;
    }

    public String getDestinationRoute() {
        return destinationRoute;
    }

    public String getFee() {
        return fee;
    }

    public String getDistance() {
        return distance;
    }

    public String getInterval() {
        return interval;
    }

}
