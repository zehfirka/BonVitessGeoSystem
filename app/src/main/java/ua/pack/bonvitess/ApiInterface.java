package ua.pack.bonvitess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/maps/api/directions/json?destination=Проспект%20перемоги%2032&lang=ua&mode=transit&origin=вулиця%20Хрещатик&language=uk&key=AIzaSyD1q8wcNP-qK4XtN2PydpoTuqIxRskE3tM")
    Call<List<routes>> getRoutes();
}
