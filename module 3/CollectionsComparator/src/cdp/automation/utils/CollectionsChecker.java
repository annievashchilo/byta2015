package cdp.automation.utils;

import java.util.Collection;
import java.util.Map;

public class CollectionsChecker {

    /**
     * special method to fill collections
     *
     * @param c    your collection
     * @param size specify the size of your collection
     */
    public static void fillCollection(Collection c, int size, boolean needClean) {
        if (needClean) c.clear();
        for (Integer i = 0; i < size; ++i) {
            c.add(i);
        }
    }

    /**
     * special method to fill the map
     *
     * @param c    your collection (Map)
     * @param size size of your collection
     */
    public static void fillCollection(Map c, int size, boolean needClean) {
        if (needClean) c.clear();
        for (int i = 0; i < size; ++i) {
            c.put(i, i);
        }
    }

    /**
     * Measure time taken on insert to the specified collection
     *
     * @param c    your collection
     * @param size of collection
     * @return elapsedTime
     */
    public static float measureInsertTime(Collection c, int size) {
        long startTime = System.currentTimeMillis();
        fillCollection(c, size, false);
        float elapsedTime = (System.currentTimeMillis() - startTime);

        System.out.printf(
                "\t%s insert: %.2f ms; %.2f us per element\n",
                c.getClass().getSimpleName(), elapsedTime, 1000.0 * elapsedTime / size);
        return elapsedTime;
    }

    /**
     * Measure time taken on insert to the specified collection (Maps)
     *
     * @param c    collection
     * @param size of collection
     * @return elapsedTime
     */
    public static float measureInsertTime(Map c, int size) {
        long startTime = System.currentTimeMillis();
        fillCollection(c, size, false);
        float elapsedTime = (System.currentTimeMillis() - startTime);

        System.out.printf(
                "\t%s insert: %.2f ms; %.2f us per element\n",
                c.getClass().getSimpleName(), elapsedTime, 1000.0 * elapsedTime / size);
        return elapsedTime;
    }

    /**
     * Measure time taken on remove the specified element from collection
     *
     * @param c you collection
     */
    public static float measureDeleteTime(Collection c) {
        int size = c.size();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; ++i) {
            c.remove(i);
        }
        float elapsedTime = (System.currentTimeMillis() - startTime);

        System.out.printf(
                "\t%s remove: %.2f ms; %.2f us per element\n",
                c.getClass().getSimpleName(), elapsedTime, 1000.0 * elapsedTime / size);
        return elapsedTime;
    }

    /**
     * Measure time taken on remove the specified element from collection
     *
     * @param c you map
     */
    public static float measureDeleteTime(Map c) {
        int size = c.size();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; ++i) {
            c.remove(i);
        }
        float elapsedTime = (System.currentTimeMillis() - startTime);

        System.out.printf(
                "\t%s remove: %.2f ms; %.2f us per element\n",
                c.getClass().getSimpleName(), elapsedTime, 1000.0 * elapsedTime / size);
        return elapsedTime;
    }

    /**
     * Measure time taken on search for the specified element in collection
     *
     * @param c – collection you want to search through
     */
    public static float measureSearchTime(Collection c) {
        int size = c.size();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; ++i) {
            c.contains(-1);
        }
        float elapsedTime = (System.currentTimeMillis() - startTime);

        System.out.printf(
                "\t%s search: %.2f ms; %.2f us per element\n",
                c.getClass().getSimpleName(), elapsedTime, 1000.0 * elapsedTime / size);
        return elapsedTime;
    }

    /**
     * Measure time taken on search for the specified element in collection
     *
     * @param c – map you want to search through
     */
    public static float measureSearchTime(Map c) {
        int size = c.size();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; ++i) {
            c.containsKey(-1);
        }
        float elapsedTime = (System.currentTimeMillis() - startTime);

        System.out.printf(
                "\t%s search: %.2f ms; %.2f us per element\n",
                c.getClass().getSimpleName(), elapsedTime, 1000.0 * elapsedTime / size);
        return elapsedTime;
    }


}
