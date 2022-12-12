package ua.pack.bonvitess;

public class Fare {
    private String currency;
    private String text;
    private long value;

    public String getCurrency() { return currency; }
    public void setCurrency(String value) { this.currency = value; }

    public String getText() { return text; }
    public void setText(String value) { this.text = value; }

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }
}
