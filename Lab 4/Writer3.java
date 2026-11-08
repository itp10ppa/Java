import java.util.List;
import java.util.Set;

public class Writer3 implements ResultWriter<Set<String>, String> {

    @Override
    public void add(Set<String> set, String value) {
        set.add(value);
    }
}
