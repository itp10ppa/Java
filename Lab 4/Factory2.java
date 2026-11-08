import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory2 implements ResultFactory<Map<Integer, List<String>>> {

    @Override
    public Map<Integer, List<String>> create() {
        return new HashMap<>();
    }
}
