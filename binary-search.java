class BinarySearch {

    private int[] nums = {};
    private int target = 0;

    BinarySearch(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int base() {
        int[] _nums = this.nums;
        int _target = this.target;

        int left = 0;
        int right = _nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (_nums[mid] == _target) {
                return mid;
            } 
            else if (_nums[mid] < _target) {
                right = mid - 1;
            }
            else if (_nums[mid] > _target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int leftBound() {
        int[] _nums = this.nums;
        int _target = this.target;

        int left = 0;
        int right = _nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (_nums[mid] == _target) {
                right = mid - 1;
            }
            else if (_nums[mid] < _target) {
                left = mid + 1;
            }
            else if (_nums[mid] > _target) {
                right = mid - 1;
            }
        }

        if (left > _nums.length || _nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightBound() {
        int[] _nums = this.nums;
        int _target = this.target;

        int left = 0;
        int right = _nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (_nums[mid] == _target) {
                left = mid + 1;
            }
            else if (_nums[mid] > _target) {
                right = mid - 1;
            }
            else if (_nums[mid] < _target) {
                left = mid + 1;
            }
        }

        if (right < 0 || _nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main (String[] args) {
        int[] nums = {1, 2, 2, 4};
        int target = 2;
        BinarySearch bs = new BinarySearch(nums, target);
        System.out.println("base: " + bs.base());
        System.out.println("leftBound: " + bs.leftBound());
        System.out.println("rightBound: " + bs.rightBound());
    }
}