package org.coder36.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark Middleton
 */
public class Find {

    public static void main( String [] args ) {

        if ( args.length != 1 ) {
            System.err.println( "Usage: java org.coder36.anagram.Find <word>" );
            System.exit( 1 );
        }

        Solver solver = new Solver( loadDict() );
        List<String[]> l = solver.find();
        for( String s: findRowWith( args[0], l ) ) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static String [] findRowWith( String word, List<String[]> wordList ){
        for ( String [] l: wordList ) {
            for ( String s: l ) {
                if ( s.equals( word ) ) {
                    return l;
                }
            }
        }
        return new String[0];
    }

    public static String [] loadDict() {
        try ( BufferedReader reader = new BufferedReader( new InputStreamReader(  Find.class.getResourceAsStream("/dictionary.txt") )  ) ) {
            List<String> l = new ArrayList<>();
            String s;
            while ( (s = reader.readLine() ) !=null ) {
                l.add(s);
            }
            return l.toArray(new String[l.size()]);
        }
        catch( IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
