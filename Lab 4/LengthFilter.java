public class LengthFilter implements Function2<String> {

    @Override
    public boolean test(String s) {
        return s.length() >= 3;
    }
}
