public class Footage {
    private final String title;
    private final String date;
    private final Integer duration;

    private final String cpr;

    public Footage(String title, String date, Integer duration, String cpr) {
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.cpr = cpr;
    }

    public String getTitle() {
        return title;
    }
    public String getDate() { return date; }
    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + title + "','" + date + "','" + duration + "','" + cpr + "')");
        return tuple.toString();
    }

}