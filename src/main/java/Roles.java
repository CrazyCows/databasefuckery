public class Roles {
    private final String topicTitle;
    private final Integer cpr;
    private final String role;

    public Roles(String topicTitle, Integer cpr, String role){
        this.topicTitle = topicTitle;
        this.cpr = cpr;
        this.role = role;
    }
    public String toString(){
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + topicTitle + "','" + cpr + "','" + role + "')");
        return tuple.toString();
    }


}
