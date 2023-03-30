public class Email {
    private final Integer cpr;
    private final String email;
    private final String descriptor;

    public Email(Integer cpr, String email, String descriptor){
        this.cpr = cpr;
        this.email = email;
        this.descriptor = descriptor;
    }
    public String toString(){
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + cpr + "','" + email + "','" + descriptor + "')");
        return tuple.toString();
    }
}
