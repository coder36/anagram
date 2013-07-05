Anagram kata
============

Given a word, find all possible anagrams of the word.
eg.

    kinship pinkish
    enlist inlets listen silent
    boaster boaters borates
    fresher refresh
    sinks skins
    knits stink
    rots sort

Tips:
* Use test driven develpment
* Write in as few a lines as possible

Taken from http://codekata.pragprog.com/2007/01/kata_six_anagra.html#more

My solution
-----------

Create a map which maps a string onto a list of strings.

    Map<String, List<String>> l = new HashMap<> ();

For each word in the dictionary, sort its letters into alphabetical order then using this as a key and add the word to the map:

    for ( String s: wordList ) {
        String r = toAlphaOrder(s);
        List<String> c = l.get( r );
        if ( c == null ) {
            c = new ArrayList<>();
            l.put( r, c );
        }
        c.add( s );
    }

The only really trick bit is working out how to do the string to aphabetical order method.

Building
--------

To make running it easier, I've made the jar executable using the mavnen-assembly-plugin

    mvn clean install
    java -cp target/* org.coder36.anagram.Find enlist

    enlist inlets listen silent





