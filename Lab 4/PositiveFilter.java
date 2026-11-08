public class PositiveFilter implements Function2<Integer> {

    @Override
    public boolean test(Integer x) {
        return x > 0;
    }
}