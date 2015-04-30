package cdp.automation.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Utils {

    public void sortByTime(Map c) {
        ValueComparator bvc = new ValueComparator(c);
        TreeMap<String, Float> sorted_map = new TreeMap<String, Float>(bvc);

        System.out.println("Unsorted measurements: " + c);

        sorted_map.putAll(c);

        System.out.println("Sorted measurements:   " + sorted_map);
    }

    class ValueComparator implements Comparator<String> {
        // Map <K, V> Map<ClassName, time>
        Map<String, Float> base;

        public ValueComparator(Map<String, Float> base) {
            this.base = base;
        }

        @Override
        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }
}
