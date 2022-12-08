package ua.pack.bonvitess;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com"; //тут має бути базове посилання https://maps.googleapis.com/
    private static Retrofit retrofit = null;

    public static ApiInterface getRetrofitClient() { //воно опирається на інтерфейс який ми робили
        if (retrofit == null){
            retrofit = new Retrofit.Builder() //тупо створення нового клієнту
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //і конвертера(я так розумію)
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
