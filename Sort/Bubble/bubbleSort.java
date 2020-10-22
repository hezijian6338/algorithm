class BubbleSort {
  BubbleSort() {

  }

  // asc
  public int[] Sort(int[] nums) {
    Boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i - 1] > nums[i]) {
          int tmp = nums[i - 1];
          nums[i - 1] = nums[i];
          nums[i] = tmp;
          swapped = true;
        }
      }
    }
    return nums;
  }

  public int[] Sort2(int[] nums) {
    int size = nums.length;
    for (int i = 0; i < size - 1; i++) {
      for (int j = 1; j < size - i; j++) {
        if (nums[j - 1] > nums[j]) {
          int tmp = nums[j - 1];
          nums[j - 1] = nums[j];
          nums[j] = tmp;
        }
      }
    }
    return nums;
  }

  // desc
  public int[] Sort3(int[] nums) {
    Boolean swapped = true;
    while (swapped) {
      swapped = false;
      for (int i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
          int tmp = nums[i + 1];
          nums[i + 1] = nums[i];
          nums[i] = tmp;
          swapped = true;
        }
      }
    }
    return nums;
  }

  public int[] Sort4(int[] nums) {
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      for (int j = size - 2; j >= i; j--) {
        if (nums[j] < nums[j + 1]) {
          int tmp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = tmp;
        }
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] nums = {7, 6, 9, 8, 7, 6, 3, 7, 5, 5, 7, 8, 9, 7, 8};
    BubbleSort bs = new BubbleSort();
    int[] sorted = bs.Sort(nums);
    for (int i : sorted) {
      System.out.print(i);
    }
    System.out.println("");
    System.out.println("=========================");
    int[] sorted2 = bs.Sort2(nums);
    for (int i : sorted2) {
      System.out.print(i);
    }
    System.out.println("");
    System.out.println("=========================");
    int[] sorted3 = bs.Sort3(nums);
    for (int i : sorted3) {
      System.out.print(i);
    }
    System.out.println("");
    System.out.println("=========================");
    int[] sorted4 = bs.Sort4(nums);
    for (int i : sorted4) {
      System.out.print(i);
    }
    System.out.println("");
  }
}