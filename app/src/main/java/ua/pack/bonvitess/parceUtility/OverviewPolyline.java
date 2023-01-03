package ua.pack.bonvitess.parceUtility;

public class OverviewPolyline {
    // клас для обробки запиту до АРІ
    private String points;

    public OverviewPolyline(String points) {
        this.points = points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPoints() {
        return points;
    }
}
