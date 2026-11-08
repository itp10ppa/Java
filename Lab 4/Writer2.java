import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Writer2 implements ResultWriter<Map<Integer, List<String>>, String> {

    @Override
    public void add(Map<Integer, List<String>> map, String value) {
        int key = value.length();
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
}
