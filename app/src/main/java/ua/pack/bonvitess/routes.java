package ua.pack.bonvitess;

public class routes {
    private String duration;
    private String html_instructions;

    public routes(String duration, String html_instructions) {
        this.duration = duration;
        this.html_instructions = html_instructions;
    }

    public String getDuration() {
        return duration;
    }

    public String getHtml_instructions() {
        return html_instructions;
    }
}
