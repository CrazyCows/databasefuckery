public class Topic {
    private final String topicTitle;
    private final String briefDescription;

    public Topic(String topicTitle, String briefDescription){
        this.topicTitle = topicTitle;
        this.briefDescription = briefDescription;
    }

    public String toString(){
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + topicTitle + "','" + briefDescription + "')");
        return tuple.toString();
    }
}
