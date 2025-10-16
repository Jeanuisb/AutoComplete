import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuicksortTester {
    public static void main(String[] args) {
        testIntegers();
        System.out.println();

        testStrings();
        System.out.println();
    }

    public static void testIntegers() {
        // Make a list of mixed-up numbers.
        ArrayList<Integer> list = new ArrayList<Integer>(List.of(6, 3, 7, 1, 4, 8, 2, 5));

        // Sort them by their "natural" order (low -> high).
        Quicksort.quicksort(list, Comparator.naturalOrder());
        System.out.println("Should be sorted: " + list);

        // Re-sort them by their reversed natural order (high -> low).
        Quicksort.quicksort(list, Comparator.reverseOrder());
        System.out.println("Should be sorted backwards: " + list);
    }

    public static void testStrings() {
        // Make a new list of the letters from "Rhodes College".
        ArrayList<String> list2 = new ArrayList<String>(
                List.of("R", "h", "o", "d", "e", "s", "C", "o", "l", "l", "e", "g", "e"));

        // Sort them by their natural order (alphabetically, but uppercase letters are "less than" lowercase).
        Quicksort.quicksort(list2, Comparator.naturalOrder());
        System.out.println("Should be sorted: " + list2);

        // Sort them by their reversed natural order (reverse alphabetically, same thing with uppercase/lowercase).
        Quicksort.quicksort(list2, Comparator.reverseOrder());
        System.out.println("Should be sorted backwards: " + list2);

        // Sort them without case sensitivity.
        Comparator<String> ignoreCaseComparator = new IgnoreCaseComparator();
        Quicksort.quicksort(list2, ignoreCaseComparator);
        System.out.println("Should be sorted, ignoring case: " + list2);
    }
}

/**
 * To write a Comparator, all you have to do is implement the "compare" function, which is exactly
 * like the "compareTo" function that is built into Java classes that implement the "Comparable" interface.
 * The reason Comparators exist is so you can write a class that can have a default way of comparing its objects
 * (implement Comparable and write a compareTo method), but then you can have secondary ways of comparing objects
 * by writing a separate Comparator class. For instance, the String object's default compareTo() method takes
 * uppercase/lowercase into account. If you want a case-insensitive comparison, you must use a separate Comparator.
 */
class IgnoreCaseComparator implements Comparator<String> {

    @Override
    /**
     * The compare function is just like compareTo. It returns a negative number (often -1) if the first object
     * is "less than" the second, a positive number (often +1) if the first object is "greater than" the second,
     * and zero if they are "equal," where "equal" in this case means any two objects where the order shouldn't
     * matter. So in this comparator, the string "abc" and "ABC" are considered equal.
     */
    public int compare(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        return s1.compareTo(s2);
    }
}
