package sorting;

public class MergeSort {

    /**
     * Merge sort in range of array
     *
     * @param array the array to merge
     * @param low   the start index
     * @param mid   the mid index
     * @param high  the end index
     */
    public static void merge(int[] array, int low, int mid, int high) {

        int length = high - low + 1;
        int[] temp = new int[length];
        int pa = low;
        int pb = mid + 1;
        int pc = 0;

        while (pa <= mid && pb <= high) {
            if (array[pa] <= array[pb]) {
                temp[pc++] = array[pa++];
            } else {
                temp[pc++] = array[pb++];
            }
        }

        while (pa <= mid) {
            temp[pc++] = array[pa++];
        }

        while (pb <= high) {
            temp[pc++] = array[pb++];
        }

        for (int i = 0; i < length; ++i) {
            array[low + i] = temp[i];
        }
    }

    /**
     * Merge Sort algorithms implement
     *
     * @param array the array to be sorted
     * @param low   the low index of array
     * @param high  the high index of array
     */
    public static void mergeSort(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) >>> 1;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        mergeSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            assert array[i] == i + 1;
        }
    }
}
