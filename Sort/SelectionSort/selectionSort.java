class SelectionSort {
  SelectionSort() {

  }

  public int[] Sort(int[] nums) {
    int size = nums.length;

    for (int i = 0; i < size - 1; i++) {
      int mainJ = i;

      for (int j = i + 1; j < size; j++) {
        if (nums[j] < nums[mainJ]) {
          mainJ = j;
        }
      }

      if (mainJ != i) {
        int tmp = nums[mainJ];
        nums[mainJ] = nums[i];
        nums[i] = tmp; 
      }
    }

    return nums;
  }

  public int[] Sort2(int[] nums) {
    int size = nums.length;

    for (int i = size - 1; i >= 0; i--) {
      int mainJ = i;

      for (int j = i - 1; j >= 0; j--) {
        if (nums[j] < nums[mainJ]) {
          mainJ = j;
        }
      }

      if (i != mainJ) {
        int tmp = nums[i];
        nums[i] = nums[mainJ];
        nums[mainJ] = tmp;
      }
    }

    return nums;
  }

  public static void main(String args[]) {
    SelectionSort ss = new SelectionSort();
    int[] nums = {3, 5, 8, 5, 4, 3, 8, 8, 2, 4, 3, 3, 7, 4, 5};
    int[] sorted = ss.Sort(nums);
    for (int i = 0; i < sorted.length; i++) {
      if (i == 0) {
        System.out.print("[");
      }
      if (i == sorted.length - 1) {
        System.out.print(sorted[i] + "]");
      } else {
        System.out.print(sorted[i] + ", ");
      }
    }
    System.out.println();
    System.out.println("=============================================");
    int[] nums2 = {3, 5, 8, 5, 4, 3, 8, 8, 2, 4, 3, 3, 7, 4, 5};
    int[] sorted2 = ss.Sort2(nums2);
    for (int i = 0; i < sorted2.length; i++) {
      if (i == 0) {
        System.out.print("[");
      }
      if (i == sorted2.length - 1) {
        System.out.print(sorted2[i] + "]");
      } else {
        System.out.print(sorted2[i] + ", ");
      }
    }
    System.out.println();
  }
}
