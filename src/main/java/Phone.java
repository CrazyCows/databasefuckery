public class Phone {
    private final Integer cpr;
    private final Integer phonenum;
    private final String descriptor;



    public Phone(Integer cpr, Integer phoneNum, String descriptor){
        this.cpr = cpr;
        this.phonenum = phoneNum;
        this.descriptor = descriptor;
    }

    public String toString(){
        StringBuilder tuple = new StringBuilder();
        tuple.append("('" + cpr + "','" + phonenum + "','" + descriptor + "')");
        return tuple.toString();
    }

}
