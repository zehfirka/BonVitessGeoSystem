package ua.pack.bonvitess.parceUtility;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Інтерфейс, який буде використовуватися Retrofit для виконання HTTP-запиту
public interface MapService {
    @GET("json")
    Call<DirectionResponse> getDirection(@Query("origin") String origin, @Query("destination") String destination, @Query("mode") String mode, @Query("key") String key);
}