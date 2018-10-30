package generics;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {
    private Map<E, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(E element) {
        map.put(element, map.containsKey(element) ? map.get(element) + 1 : 1);
    }

    @Override
    public int getCount(E element) {
        Integer count = map.get(element);
        return count != null ? count : 0;
    }

    @Override
    public int remove(E element) {
        Integer count = map.remove(element);
        return count != null ? count : 0;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends E> source) {
        for (Map.Entry<? extends E, Integer> entry: source.toMap().entrySet()) {
            Integer count = entry.getValue();
            map.put(entry.getKey(), map.containsKey(entry) ? map.get(entry) + count : count);
        }
    }

    @Override
    public Map<E, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<? super E, Integer> destination) {
        destination.putAll(map);
    }
}
