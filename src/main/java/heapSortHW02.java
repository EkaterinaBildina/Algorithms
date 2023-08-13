public class heapSortHW02 {

    public static void main(String[] args) {
        int[] sortArr = {11, 8, 18, -1, 10, -2, 4};

        int beforeTime = (int) System.currentTimeMillis();
        heapSort(sortArr);

        for (int i = 0; i < sortArr.length; ++i) {
            System.out.print(sortArr[i] + "  ");
        }

        int afterTime = (int) System.currentTimeMillis();
        System.out.println("\n" + "time = " + (afterTime - beforeTime) + "msec.");
    }

    private static int LeftElem(int i) {
        return (2 * i + 1);
    }

    private static int RightElem(int i) {
        return (2 * i + 2);
    }

    private static void heapify(int[] sortArr, int i, int size) {
        int l = LeftElem(i);
        int r = RightElem(i);
        int largest = i;

        if (l < size && sortArr[l] > sortArr[largest]) {
            largest = l;
        }
        if (r < size && sortArr[r] > sortArr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = sortArr[i];
            sortArr[i] = sortArr[largest];
            sortArr[largest] = swap;

            heapify(sortArr, size, largest);
        }
    }

    public static int pop(int[] sortArr, int size) {

        int top = sortArr[0];
        sortArr[0] = sortArr[size - 1];
        heapify(sortArr, 0, size - 1);
        return top;
    }

    public static void heapSort(int sortArr[]) {
        int n = sortArr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(sortArr, i, n);
        }

        for (int i = n; i > 0; i--) {
            sortArr[i - 1] = pop(sortArr, i);
        }
    }
}
