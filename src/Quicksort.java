import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Collections.swap;

public class Quicksort {

    public static <E> void quicksort(ArrayList<E> arrayList, Comparator<E> comparator) {
        quicksort(arrayList, comparator, 0, arrayList.size() - 1);
    }

    private static <E> void quicksort(ArrayList<E> arrayList, Comparator<E> comparator, int first, int last) {
        if (first < last) {
            int pivIndex = partition(arrayList, comparator, first, last);
            quicksort(arrayList, comparator, first, pivIndex - 1);
            quicksort(arrayList, comparator, pivIndex + 1, last);
        }
    }

    private static <E> int partition(ArrayList<E> arrayList, Comparator<E> comparator, int first, int last) {

        E pivot = (E) arrayList.get(first);

        int up = first;
        int down = last;

        do {
            while ((up < last) && (comparator.compare(pivot, arrayList.get(up))) >= 0)
            {
                up++;
            }
            while ((comparator.compare(pivot, arrayList.get(down))) < 0)
            {
                down--;
            }

            if ( up < down)
            {
                swap(arrayList,up,down);
            }
        }
        while (up < down);

        swap(arrayList,first,down);

        return down; // remove this line when you start coding.
    }
}
