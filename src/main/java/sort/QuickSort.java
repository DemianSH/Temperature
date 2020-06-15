package sort;

public class QuickSort implements Sort {

    public void sort(double[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(double[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            sort(array, begin, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    private int partition(double[] array, int begin, int end) {
        double pivot = array[end];
        int index = begin - 1;

        for (int i = begin; i < end; i++) {
            if (array[i] <= pivot) {
                index++;

                double swapTemp = array[index];
                array[index] = array[i];
                array[i] = swapTemp;
            }
        }

        double swapTemp = array[index + 1];
        array[index + 1] = array[end];
        array[end] = swapTemp;

        return index + 1;
    }

}
