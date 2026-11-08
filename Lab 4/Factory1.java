import java.util.ArrayList;
import java.util.List;

public class Factory1 implements ResultFactory<List<List<Integer>>> {

    @Override
    public List<List<Integer>> create() {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        result.add(list1);
        result.add(list2);
        return result;
    }
}
