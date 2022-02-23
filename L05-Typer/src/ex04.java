

public class ex04 {
    private String first;
    private String middle;
    private String last;

    public ex04(String first, String middle, String last) {
        this.first = first;
        this.middle = middle;
        this.last = last;
    }

    public ex04(String first, String last){
        this.first = first;
        this.middle = "";
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFullName(){
        if(middle.isEmpty()) {
            return first + " " + last;
        }
        return first + " "  + middle + " " + last;
    }

    public String getUsername(){
        return first.substring(0,2).toUpperCase() + middle.length() + last.substring(last.length()-2).toLowerCase();
    }

    public String getInits(){
        return "" + first.charAt(0) + last.charAt(0);
    }

    public String getCryptoInits(int count) {
        int f = first.charAt(0) + count;
        char fc = (char) f;
        int l = last.charAt(0) + count;
        char lc = (char) l;
        if(!middle.isEmpty()) {
            int m = middle.charAt(0) + count;
            char mc = (char) m;
            return "" + fc + mc + lc;
        }
        return "" + fc + lc;
    }
}
