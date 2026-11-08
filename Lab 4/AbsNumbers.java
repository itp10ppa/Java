public class AbsNumbers implements Function<Integer, Integer> {

    @Override
    public Integer apply(Integer x) {
        return Math.abs(x);
    }
}
