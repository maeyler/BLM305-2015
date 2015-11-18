class Midterm implements Runnable {
    static Thread one, two;
    String name; 
    Midterm(String s) { name = s; }
    public void run() { delay(700, name); }
    static void delay(int d, String n) {
        System.out.println(n +" begins");
        long s = System.currentTimeMillis();
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) { }
        long t = System.currentTimeMillis();
        System.out.println(" "+one.getState());
        System.out.println(n+" ends in "+ (t-s));
    }
    public static void main (String[] args) {
        one = new Thread(new Midterm("one"));
        two = new Thread(new Midterm("two"));
        one.start(); 
        delay(300, "main"); 
        two.start();
    }
}

class Point implements Comparable<Point> {
    final int hour, minute, time;
    Point(int h, int m) {
        hour = h; minute = m; 
        time = 60*h + m;
    }
    public int hashCode() {
        return time;
    }
    public boolean equals(Object x) {
        return time == x.hashCode();
    }
    public int compareTo(Point p) {
        return time - p.time;
    }
    public String toString() { // "9:00"
        String m = ""+minute;
        if (m.length() == 1) m = "0"+m;
        return hour+":"+m;
    }
}

class Activity {
    String name; Point start, end; 
    public Activity(String n, Point s, Point e) {
        name = n; start = s; end = e;
    }
    public int duration() {
        return end.time - start.time;
    }
    public String toString() { // "walk  8:25-9:00"
        return name+"  "+start+"-"+end;
    }
    public static Point makePoint(int h, int m) { 
        return new Point(h, m);
    }
    final static Point p = makePoint(8, 25);
    final static Point q = makePoint(9, 0);
    final static Activity y = new Activity("walk", p, q);
    final static Point[] a = { p, null, p, q };
    public static void main(String[] args) {
        System.out.println("Sample Activity\n"+y);
        System.out.println("Duration = "+y.duration());
    }
}
