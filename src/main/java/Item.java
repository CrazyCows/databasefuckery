public class Item {
    private final String date;
    private final String topic;
    private final String description;
    private final Integer numOfViewers;
    private final String footageTitle;

    public Item(String date, String topic, String description, Integer numOfViewers, String footageTitle){
        this.date = date;
        this.topic = topic;
        this.description = description;
        this.numOfViewers = numOfViewers;
        this.footageTitle = footageTitle;
    }

    public String toString(){
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + date + "','" + topic + "','" + description + "','" + numOfViewers + "','" + footageTitle + "')");
        return tuple.toString();
    }
}
