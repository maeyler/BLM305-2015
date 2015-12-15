// Author: Eyler -- Oct 2012
// counts all words within a given text file
// makes a list of lne numbers for each word

import java.io.*;
import java.util.*;
import java.net.URL;

class Concordance  {

    Object src;
    Integer line = 0;
    Map<String, NumList> map;
    
    public Concordance(String fn) throws IOException {
        this(new File(fn));
    }
    public Concordance(File f) throws IOException {
        this(new FileReader(f)); src = f;
    }
    public Concordance(URL u) throws IOException {
        this(u.openStream()); src = u;
    }
    public Concordance(InputStream is) throws IOException {
        this(new InputStreamReader(is)); src = is;
    }
    public Concordance(InputStream is, String enc) throws IOException {
        this(new InputStreamReader(is, enc)); src = is;
    }
    public Concordance(Reader r) throws IOException {
        map = new TreeMap<String, NumList>();
        BufferedReader br = new BufferedReader(r);
        String s;
	while ((s = br.readLine()) != null) 
            processLine(s);
        br.close(); src = r;
    }
    void processLine(String src) {
        line++;
        String[] sa = src.split("\\p{Punct}|\\s");
        for (String w: sa) 
            if (w.length() > 0) processWord(w);
    }
    void processWord(String w) {
        NumList L = map.get(w);
        if (L == null) {
            L = new NumList();
            map.put(w, L);
	}
	L.add(line);    
    }
    public void report(String fn) throws IOException {
        PrintStream out = new PrintStream(fn);
        int n = report(out); out.close();
        System.out.println(n+" words written to "+fn);
    }
    public int report(PrintStream out) {
        for (String s: map.keySet()) 
            out.println(s+": "+map.get(s));
        return map.keySet().size();
    }
    public static void main(String args[]) throws IOException {
        File f = new File("text", "Browser.properties");
        new Concordance(f).report("out.txt");
    }
}

/*  a truncated ArrayList, limited to M elements
class NumList extends ArrayList<Integer> { //first design
*/
class NumList extends AbstractList<Integer> { //better design
    int max;  //maximum number of elements
    int num;  //actual number of elements
    ArrayList<Integer> lst;
    public NumList() { this(20); }
    public NumList(int M) { 
        max = Math.max(M, 5); num = 0;
        lst = new ArrayList<Integer>(5);
    }
    public int size() { return num; }
    public Integer get(int i) {
        return (lst != null? lst.get(i) : null);
    }
    public boolean add(Integer i) {
        num++; 
        if (lst != null)  {
            if (num > max) lst = null;
            else lst.add(i);
        } 
        return true;
    }
    public String toString() {
        return (lst != null? lst.toString() : "("+num+")");
    }
}
