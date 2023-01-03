package ua.pack.bonvitess.parceUtility;

import com.google.gson.annotations.SerializedName;

public class Route {
    // клас для обробки запиту до АРІ

    @SerializedName("overview_polyline") //використовується для коректної обробки запиту
    private OverviewPolyline overviewPolyline;

    public Route(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }

    public OverviewPolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public void setOverviewPolyline(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
    }
}
