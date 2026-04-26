class BinarySearch {
    public static int binarySearch(int[] list, int num) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] < num){
                low = mid + 1;
            } else if(list[mid] > num) {
                high = mid - 1;
            } else if(list[mid] == num) {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] list = new int[100];
        for(int i = 0; i < 100; i++){
            list[i] = i + 1;
        }

        int num = 57;
        System.out.printf("The position of the 57th element in the list is: %d\n", binarySearch(list, 57));
        System.out.printf("The position of the 130th element in the list is: %d\n", binarySearch(list, 130));
    }
}
