import java.util.HashSet;
import java.util.Set;

public class Factory3 implements ResultFactory<Set<String>> {

    @Override
    public Set<String> create() {
        return new HashSet<>();
    }
}
