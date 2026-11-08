public class NegativeFilter implements Function2<int[]> {

    @Override
    public boolean test(int[] arr) {
        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}