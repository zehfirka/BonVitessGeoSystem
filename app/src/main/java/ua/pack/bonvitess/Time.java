package ua.pack.bonvitess;

public class Time {
    private String text;
    private String timeZone;
    private long value;

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    public String getTimeZone() { return timeZone; }
    public void setTimeZone(String value) { this.timeZone = value; }

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }
}
