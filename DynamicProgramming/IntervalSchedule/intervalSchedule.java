import java.util.Arrays;

class IntervalSchedule {
  private int[][] intvs;

  public IntervalSchedule(int[][] intvs) {
    this.intvs = intvs;
  }

  public int intervalSchedule() {
    if (this.intvs.length == 0) {
      return 0;
    }

    Arrays.sort(this.intvs, (v1, v2) -> {
      return v1[1] - v2[1];
    });

    int count = 1;

    int x_end = this.intvs[0][1];
      for (int intv[] : intvs) {
        int start = intv[0];
        if (start >= x_end) {
          count++;
          x_end = intv[1];
        }
      }
    return count;
  }

  public static void main(String[] args) {
    int[][] intvs = {{1, 3}, {2, 4}, {3, 6}};

    IntervalSchedule is = new IntervalSchedule(intvs);
    System.out.println(is.intervalSchedule());
  }
}