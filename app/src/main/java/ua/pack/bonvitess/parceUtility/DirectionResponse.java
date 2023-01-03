package ua.pack.bonvitess.parceUtility;

import java.util.List;

public class DirectionResponse {
    // клас для обробки запиту до АРІ
    private final List<Route> routes;

    public DirectionResponse(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
