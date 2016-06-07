package Common;

/**
 * Created by wesley.smyth on 02/06/2016.
 */
public enum enumExample {

    MONDAY("mon"),
    TUESDAY("tues"),
    WEDNESDAY("wed");

    private final String days;

    enumExample(String days) {
        this.days = days;
    }

    public String getDays() {
        return this.days;
    }
}