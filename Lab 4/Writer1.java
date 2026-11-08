import java.util.List;

public class Writer1 implements ResultWriter<List<List<Integer>>, Integer> {

    @Override
    public void add(List<List<Integer>> result, Integer value) {
        if (value >= 0) {
            result.get(0).add(value);
        }
        else {
            result.get(1).add(value);
        }
    }
}
