public class Sorter<T extends Comparable<? super T>> {
    public void mergeSort(T[] list, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(list, start, mid);
            mergeSort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
    }

    private void merge(T[] arr, int start, int mid, int end){
        @SuppressWarnings("unchecked")
        T[] ret = (T[]) new Comparable[end - start + 1];
        int i = start, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if(arr[i].compareTo(arr[j]) < 0)
                ret[k++] = arr[i++];
            else
                ret[k++] = arr[j++];
        }
        while (i <= mid) ret[k++] = arr[i++];
        while (j <= end) ret[k++] = arr[j++];
        for (i = start; i <= end; i++) { arr[i] = ret[i - start]; }
    }
}