import java.util.*;

enum Month { Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec }

class Date {
    int day; Month mon; int year;
    public Date(int d, Month m, int y) {
        day = d; mon = m; year = y;
    }
    public String toString() {
        return day +"/"+ mon +"/"+ year;
    }
}

class Quiz1 {
    static Date p = new Date(1, Month.Jan, 2015);
    static Date q = new Date(9, Month.Jan, 1983);
    static Date[] a = new Date[5];
    static List<Date> b;
    static Set<Date> h;
    public static void main(String[] args) {
        System.out.println(p);
        System.out.println(q);
        a[0] = p; a[2] = p; a[3] = q;
        b = Arrays.asList(a);
        System.out.println(b);
        h = new HashSet<>(b);
        System.out.printf("%s %s %n", h.size(), h.contains(p));
    }
}
