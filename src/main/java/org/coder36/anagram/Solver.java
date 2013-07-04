package org.coder36.anagram;

import java.util.*;

/**
 * @author Mark Middleton
 */
public class Solver {

    private final String [] wordList;

    public Solver( String [] wordList ) {
        this.wordList = wordList;
    }

    public List<String[]> find() {

        Map<String, List<String>> l = new HashMap<> ();
        for ( String s: wordList ) {
            String r = toAlphaOrder(s);
            List<String> c = l.get( r );
            if ( c == null ) {
                c = new ArrayList<>();
                l.put( r, c );
            }
            c.add( s );
        }

        List<String[]> list = new ArrayList<>();
        for ( List<String> g: l.values() ) {
            Collections.sort(g);
            list.add(g.toArray(new String[0]));
        }
        return list;
    }

    /**
     * re-order letters into alphabetic order
      */
    protected String toAlphaOrder(String str) {
        String m = "";
        List<String> l = new ArrayList<>();
        for ( int i=0; i < str.length(); i++ ) {
            l.add(str.substring(i, i + 1));
        }
        Collections.sort( l );

        for ( String s: l ) {
            m = m + s;
        }
        return m;
    }
}
