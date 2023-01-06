package ua.pack.bonvitess.parceUtility;

import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("html_instructions")
    private String htmlInstructions;

    public String getHtmlInstructions() {
        return htmlInstructions;
    }

}
//html_instructions