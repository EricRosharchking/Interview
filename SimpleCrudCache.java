import java.util.HashMap;
import java.util.PriorityQueue;

public class SimpleCrudCache implements CrudCacheInterface {

    /**
     * limited size collection is not available in the jdk lib, need to implement
     * the max size limitation for frequency and cache
     */

    // actual cache used for saving objects with the highest occurrences, with limit
    // size (10)
    private HashMap<String, Object> cache;
    // keep track of the occurrences of each objects, by linking object IDs with
    // occurrences
    private HashMap<String, Integer> occurrence;
    // keep the 10 most visited objects' ids and their times of visit
    private PriorityQueue<Occ> frequency;

    public SimpleCrudCache() {
        cache = new HashMap<>();
        occurrence = new HashMap<>();
        frequency = new PriorityQueue<Occ>(10, (Occ a, Occ b) -> a.compareTo(b));
    }

    @Override
    public Object get(String str) {

        // increase occurrence count
        addVisited(str);
        // check the frequency for leastVisitedItem, whether the obj is in the cache
        boolean visited = false;
        // remove the not so frequently visited item from the cache with checks
        for (Occ o : frequency) {
            if (o.getId().equals(str)) {
                visited = true;
            }
        }
        // if the item is not in the most visited list, add it in. Limit the size of the
        // frequency list to 10.
        // if the item is already in the most visited list, update the frequency by
        // removing the original Occ and add in the new one because of priorityQueue's
        // operation cost (changing the item will be more costly than removing and
        // adding a new one)
        if (!visited && occurrence.get(str) >= frequency.peek().getCount()) {
            while (frequency.size() >= 10) {
                // remove the least visited obj from the cache
                String toRemove = frequency.poll().getId();
                cache.remove(toRemove);
            }
            frequency.add(new Occ(str, occurrence.get(str)));
        } else {
            frequency.removeIf(o -> o.getId().equals(str));
            frequency.add(new Occ(str, occurrence.get(str)));
        }
        // return the object from cache if it exists in the cache, else retrieve from
        // the DB and add obj in the cache if it's in the most visited list
        if (cache.keySet().contains(str)) {
            return cache.get(str);
        }
        //
        Object obj = getFromDB(str);
        if (frequency.contains(new Occ(str, occurrence.get(str)))) {
            cache.put(str, obj);
        }
        return obj;
    }

    private Object getFromDB(String str) {
        return new Object();
    }

    @Override
    public void add(Object obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(String str) {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Object obj) {
        // TODO Auto-generated method stub

    }

    private void addVisited(String str) {
        if (occurrence.keySet().contains(str)) {
            occurrence.put(str, occurrence.get(str) + 1);
        } else {
            occurrence.put(str, 1);
        }
    }

    class Occ implements Comparable<Occ> {
        private String id;
        private Integer count;

        Occ() {
            // super();
        }

        Occ(String id, Integer count) {
            this.id = id;
            this.count = count;
        }

        public String getId() {
            return id;
        }

        public Integer getCount() {
            return count;
        }

        public void visited() {
            count++;
        }

        @Override
        public int compareTo(SimpleCrudCache.Occ o) {
            return count.compareTo(o.getCount());
        }

        @Override
        public boolean equals(Object o) {
            if (null != o && o instanceof SimpleCrudCache.Occ) {
                return id.equals(((SimpleCrudCache.Occ) o).getId())
                        && count.equals(((SimpleCrudCache.Occ) o).getCount());
            }
            return false;
        }
    }
}
