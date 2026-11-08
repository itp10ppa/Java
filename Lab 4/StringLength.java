public class StringLength implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
