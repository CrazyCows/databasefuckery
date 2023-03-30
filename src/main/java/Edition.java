public class Edition {
    private final String date;
    private final Integer duration;
    private final Integer cpr;

    public Edition(String date, Integer duration, Integer cpr){
        this.date = date;
        this.duration = duration;
        this.cpr = cpr;
    }

    public String toString(){
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + date + "','" + duration + "','" + cpr + "')");
        return tuple.toString();
    }

}
