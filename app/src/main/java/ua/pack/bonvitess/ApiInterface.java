package ua.pack.bonvitess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
// /todos
    @GET("/maps/api/directions/json?destination=вулиця%20Маршала%20Малиновського&lang=ua&mode=transit&origin=вулиця%20Олекси%20Тихого&language=uk&key=AIzaSyD1q8wcNP-qK4XtN2PydpoTuqIxRskE3tM")  //сюди вставляється все що йде після https://maps.googleapis.com/
    Call<List<Root>> getRoutes();
}
