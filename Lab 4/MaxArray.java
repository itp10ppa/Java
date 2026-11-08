public class MaxArray implements Function<int[], Integer> {

    @Override
    public Integer apply(int[] arr) {
        int maxElement = arr[0];
        for (int i : arr) {
            if (i > maxElement) {
                maxElement = i;
            }
        }
        return maxElement;
    }
}
