package ua.pack.bonvitess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/todos")  //сюди вставляється все що йде після https://maps.googleapis.com/
    Call<List<routes>> getRoutes();
}
