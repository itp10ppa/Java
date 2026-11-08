import java.util.List;

public class ListLength implements Function<List<Integer>, Integer> {

    @Override
    public Integer apply(List<Integer> list) {
        return list.size();
    }
}
