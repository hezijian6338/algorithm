import java.util.LinkedList;
import java.util.List;

class backtrack {
    public List<List<Integer>> result = new LinkedList<>();

    /* 主函数, 输入一组不重复的数列, 求他们的全排列 */
    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        _backtrack(nums, track);
        return result;
    }

    // 路径: 记录在 track中
    // 选择列表: 那些不在 track中的 nums元素
    // 结束条件: nums元素全在 track中
    public void _backtrack(int[] nums, LinkedList<Integer> track) {
        // 结束条件
        if (nums.length == track.size()) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 在 track中出现的, 不在选择列表
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            _backtrack(nums, track);
            // 移除选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        backtrack bt = new backtrack();
        List<List<Integer>> res = bt.permute(nums);

        System.out.println(res);
    }

}