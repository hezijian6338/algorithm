class InsertionSort {
  InsertionSort() {

  }

  public int[] Sort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int key = nums[i];

      int j = 0;
      for (j = i - 1; (j >= 0) && (nums[j] > key); j--) {
        nums[j + 1] = nums[j];
      }
      nums[j + 1] = key; 
    }

    return nums;
  }

  public int[] Sort2(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      int key = nums[i];

      int j = 0;
      for (j = i - 1; (j >= 0) && (nums[j] < key); j--) {
        nums[j + 1] = nums[j];
      }

      nums[j + 1] = key;
    }

    return nums;
  }

  public static void main(String[] args) {
    InsertionSort is = new InsertionSort();
    int[] nums = {3, 2, 3, 6, 2, 4, 3, 4, 9, 4, 4, 5, 3, 1, 9};
    int[] sorted = is.Sort(nums);
    for (int i : sorted) {
      System.out.print(i + " ");
    }
    System.out.println("");
    System.out.println("=============================");
    int[] sorted2 = is.Sort2(nums);
    for (int i : sorted2) {
      System.out.print(i + " ");
    }
    System.out.println("");
    System.out.println("=============================");
  }
}