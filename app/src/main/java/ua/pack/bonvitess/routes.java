package ua.pack.bonvitess;

import com.google.gson.annotations.SerializedName;

public class routes {
    @SerializedName("id")
    private String title;
    @SerializedName("title")
    private String body;

    public routes(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
